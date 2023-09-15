package tranhph26979.fpoly.app_monan_bai2.model

import tranhph26979.fpoly.app_monan_bai2.R

class foodList {
    fun createFoodList(): ArrayList<Food> {

        val foodlist = ArrayList<Food>()
        foodlist.add(Food("Cháo trai", "cháo", R.drawable.chaotrai))
        foodlist.add(Food("Cháo sườn", "cháo", R.drawable.chaosuon))
        foodlist.add(Food("Cháo ngao", "cháo", R.drawable.chaongao))
        foodlist.add(Food("Cháo lươn", "cháo", R.drawable.chaoluon))
        foodlist.add(Food("Cháo hàu sữa", "cháo", R.drawable.chaohau))
        foodlist.add(Food("Cháo chim bồ câu", "cháo", R.drawable.chaochimbocau))
        foodlist.add(Food("Cocacola", "đồ uống", R.drawable.cocacola))
        foodlist.add(Food("Bạc xỉu", "đồ uống", R.drawable.bacxiu))
        foodlist.add(Food("Cà phê", "đồ uống", R.drawable.cafe))
        foodlist.add(Food("Nước cam", "đồ uống", R.drawable.nuoccam))
        foodlist.add(Food("Trà đào", "đồ uống", R.drawable.tradao))
        foodlist.add(Food("Trà sữa", "đồ uống", R.drawable.trasua))
        foodlist.add(Food("Xúc xích", "thức ăn nhanh", R.drawable.xuxich))
        foodlist.add(Food("Kimbap", "thức ăn nhanh", R.drawable.kimbap))
        foodlist.add(Food("Gà rán", "thức ăn nhanh", R.drawable.garan))
        foodlist.add(Food("Pizza hawai", "thức ăn nhanh", R.drawable.pizza))
        foodlist.add(Food("Bánh mỳ Donerkebab", "thức ăn nhanh", R.drawable.donerkebab))
        foodlist.add(Food("Combo hamburger với khoai tây chiên", "thức ăn nhanh", R.drawable.combo))
        foodlist.add(Food("Lẩu dê", "lẩu", R.drawable.laude))
        foodlist.add(Food("Lẩu nấm", "lẩu", R.drawable.launam))
        foodlist.add(Food("Lẩu kim chi", "lẩu", R.drawable.laukimchi))
        foodlist.add(Food("Lẩu hải sản", "lẩu", R.drawable.lauhaisan))
        foodlist.add(Food("Lẩu ếch lá lốt", "lẩu", R.drawable.lauechlalot))
        foodlist.add(Food("Lẩu gà nấm chua cay", "lẩu", R.drawable.lauganam))

        return foodlist
    }
}