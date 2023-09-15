package tranhph26979.fpoly.app_monan_bai2.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SharedViewModelFactory(private val context:Context,private val foodList: ArrayList<Food>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel(context,foodList) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}