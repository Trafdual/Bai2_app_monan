package tranhph26979.fpoly.app_monan_bai2.activity

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import tranhph26979.fpoly.app_monan_bai2.R
import tranhph26979.fpoly.app_monan_bai2.model.Food
import tranhph26979.fpoly.app_monan_bai2.model.SharedViewModel
import tranhph26979.fpoly.app_monan_bai2.model.SharedViewModelFactory
import tranhph26979.fpoly.app_monan_bai2.model.foodList

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var sharedViewModel: SharedViewModel
    private val foodList:foodList=foodList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar:Toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)

        val customview=LayoutInflater.from(this).inflate(R.layout.custom_toolbar,null)
        val params=Toolbar.LayoutParams(
            Toolbar.LayoutParams.WRAP_CONTENT,
            Toolbar.LayoutParams.WRAP_CONTENT,Gravity.CENTER
        )
        supportActionBar?.setCustomView(customview,params)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        sharedViewModel=ViewModelProvider(this,SharedViewModelFactory(applicationContext,foodList.createFoodList())).get(SharedViewModel::class.java)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_actionbar,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.next_item ->{
                navController.navigate(R.id.action)

                return true
            }

            else-> return super.onOptionsItemSelected(item)
        }
    }


}