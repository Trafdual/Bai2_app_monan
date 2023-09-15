package tranhph26979.fpoly.app_monan_bai2.model

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel(private val context: Context, private val foodList: ArrayList<Food>) :
    ViewModel() {

    private lateinit var sharedPreferences: SharedPreferences
    private val selectedFoodListKey = "selectedFoodList"

    val selectedFoodList: MutableLiveData<List<Food>> = MutableLiveData()

    fun saveSelectedFoodList() {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putStringSet(
            selectedFoodListKey,
            selectedFoodList.value?.map { it.nameFood }?.toSet()
        )
        editor.apply()
    }

    fun restoreSelectedFoodList() {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val restoredSet = sharedPreferences.getStringSet(selectedFoodListKey, null)

        val restoredList = restoredSet?.mapNotNull { name ->
            foodList.find { it.nameFood == name }
        }
        if (selectedFoodList.value == null) {
            selectedFoodList.value = restoredList ?: emptyList()
        } else {
            selectedFoodList.value = restoredList!!
        }

    }

    fun addSelectedFood(food: Food) {
        val currentList = selectedFoodList.value?.toMutableList() ?: mutableListOf()
        currentList.add(food)
        selectedFoodList.value = currentList
    }

    fun removeSelectedFood(food: Food) {
        val currentList = selectedFoodList.value?.toMutableList() ?: mutableListOf()
        currentList.remove(food)
        selectedFoodList.value = currentList
    }
}