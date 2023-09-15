package tranhph26979.fpoly.app_monan_bai2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import tranhph26979.fpoly.app_monan_bai2.R
import tranhph26979.fpoly.app_monan_bai2.model.Food

class FinalAdapter(private var selectedFoodList:List<Food>,private val context: Context):BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return selectedFoodList.size
    }

    override fun getItem(positon: Int): Any {
       return selectedFoodList
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }
    private class ViewHolder {
        lateinit var tvtenmonanslt: TextView
        lateinit var imgslt: ImageView
    }
    fun updateSelectedFoods(foods: List<Food>) {
        selectedFoodList = foods
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder
        if (convertView==null){
            view=inflater.inflate(R.layout.custom_selectedfood,parent,false)
            viewHolder=ViewHolder()
            viewHolder.tvtenmonanslt=view.findViewById(R.id.tvtenmonanslt)
            viewHolder.imgslt=view.findViewById(R.id.imgslt)
            view.tag=viewHolder
        }
        else{
            view=convertView
            viewHolder= convertView.tag as ViewHolder
        }
        val selectedFood=selectedFoodList[position]
        viewHolder.tvtenmonanslt.text=selectedFood.nameFood
        viewHolder.imgslt.setImageResource(selectedFood.imgFood)
        return view
    }
}