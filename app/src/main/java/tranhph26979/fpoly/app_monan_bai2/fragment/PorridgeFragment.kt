package tranhph26979.fpoly.app_monan_bai2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tranhph26979.fpoly.app_monan_bai2.R
import tranhph26979.fpoly.app_monan_bai2.adapter.FoodAdapter
import tranhph26979.fpoly.app_monan_bai2.model.Food
import tranhph26979.fpoly.app_monan_bai2.model.SharedViewModel
import tranhph26979.fpoly.app_monan_bai2.model.SharedViewModelFactory
import tranhph26979.fpoly.app_monan_bai2.model.foodList


class PorridgeFragment : Fragment() {
    private lateinit var list_porridge: ListView
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var viewModel: SharedViewModel
    private lateinit var selectedFoodList: List<Food>
    private var foodList: foodList = foodList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_porridge, container, false)
        list_porridge = view.findViewById(R.id.list_po)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foodchao = foodList.createFoodList().filter { it.loaiFood == "cháo" }
        viewModel =
            ViewModelProvider(
                requireActivity(), SharedViewModelFactory(
                    context!!,
                    foodchao as ArrayList<Food>
                )
            ).get(
                SharedViewModel::class.java
            )
        viewModel.restoreSelectedFoodList()
        selectedFoodList = emptyList()
        foodAdapter = FoodAdapter(requireContext(), foodchao, selectedFoodList)
        list_porridge.adapter = foodAdapter
        foodAdapter.SetOnFoodCheckedChangeListener { food, isChecked ->
            if (!isChecked) {
                viewModel.removeSelectedFood(food)
            } else {
                viewModel.addSelectedFood(food)
            }
        }
        viewModel.selectedFoodList.observe(viewLifecycleOwner, Observer { foodList ->
            selectedFoodList = foodList
            foodAdapter.updateSelectedFoodList(selectedFoodList)
        })

    }


    override fun onPause() {
        super.onPause()
        viewModel.saveSelectedFoodList()
    }


}