package tranhph26979.fpoly.app_monan_bai2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import tranhph26979.fpoly.app_monan_bai2.R
import tranhph26979.fpoly.app_monan_bai2.model.Food

class FoodAdapter(var context: Context, var mangFood:ArrayList<Food>, var selectedFoodList:List<Food>) : BaseAdapter() {
    private var OnFoodCheckedChangeListener:((Food,Boolean)->Unit)?=null
    class ViewHolder(row:View){
        var imgmonan:ImageView
        var tvtenmonan:TextView
        var checkBox:CheckBox
        init {
            imgmonan=row.findViewById(R.id.imgmonan)
            tvtenmonan=row.findViewById(R.id.tvtenmonan)
            checkBox=row.findViewById(R.id.checkbox)
        }
    }
    override fun getCount(): Int {
        return mangFood.size
    }

    override fun getItem(position: Int): Any {
        return mangFood.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    fun SetOnFoodCheckedChangeListener(listener:(Food,Boolean)->Unit){
        OnFoodCheckedChangeListener=listener
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder: ViewHolder
        if (convertView==null){
            var layoutInflater:LayoutInflater=LayoutInflater.from(context)
            view=layoutInflater.inflate(R.layout.item_list_monan,null)
            viewHolder= ViewHolder(view)
            view.tag=viewHolder
        }
        else{
            view=convertView
            viewHolder=convertView.tag as ViewHolder
        }

        var food:Food=getItem(position) as Food
        viewHolder.checkBox.setOnCheckedChangeListener(null)
        viewHolder.checkBox.isChecked=selectedFoodList.contains(food)
        viewHolder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            OnFoodCheckedChangeListener?.invoke(food,isChecked)
        }
        viewHolder.tvtenmonan.text=food.nameFood
        viewHolder.imgmonan.setImageResource(food.imgFood)
        return view as View
    }
    fun updateSelectedFoodList(selectedList: List<Food>) {
        selectedFoodList = selectedList
        notifyDataSetChanged()
    }
}