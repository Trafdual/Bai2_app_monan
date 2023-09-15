package tranhph26979.fpoly.app_monan_bai2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tranhph26979.fpoly.app_monan_bai2.R
import tranhph26979.fpoly.app_monan_bai2.adapter.FinalAdapter
import tranhph26979.fpoly.app_monan_bai2.model.Food
import tranhph26979.fpoly.app_monan_bai2.model.SharedViewModel


class FinalFragment : Fragment() {
   private lateinit var listView:ListView
   private lateinit var finalAdapter: FinalAdapter
   private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view =inflater.inflate(R.layout.fragment_final, container, false)
        listView=view.findViewById<ListView>(R.id.list_food)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel=ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        finalAdapter= FinalAdapter(sharedViewModel.selectedFoodList.value?: emptyList(),requireContext())
        listView.adapter=finalAdapter
        sharedViewModel.selectedFoodList.observe(viewLifecycleOwner){selectedFoods->
            finalAdapter.updateSelectedFoods(selectedFoods)
        }
        sharedViewModel.restoreSelectedFoodList()
    }

}