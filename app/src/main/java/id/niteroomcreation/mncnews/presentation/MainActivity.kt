package id.niteroomcreation.mncnews.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint
import id.niteroomcreation.mncnews.R
import id.niteroomcreation.mncnews.databinding.AMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: AMainBinding;
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.cToolbarHome.toolbarHome)
        setupNavigation();
        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment -> {
                    setSupportActionBar(binding.cToolbarHome.toolbarHome)
                    binding.cToolbarHome.toolbarHome.visibility = View.VISIBLE
                    binding.cToolbarDetail.toolbarDetail.visibility = View.GONE
                    supportActionBar?.title = ""
                    println("home")
                }
                R.id.detailFragment -> {
                    setSupportActionBar(binding.cToolbarDetail.toolbarDetail)
                    binding.cToolbarHome.toolbarHome.visibility = View.GONE
                    binding.cToolbarDetail.toolbarDetail.visibility = View.VISIBLE
                    supportActionBar?.title = ""
                    println("detail")
                }
            }
        })
    }

    private fun setupNavigation() {
        val navigationFragment = supportFragmentManager.findFragmentById(binding.mainNavFragment.id)
                as NavHostFragment
        navController = navigationFragment.navController;

        //appbar config
        val appbarConfig = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.detailFragment
            )
        )
        setupActionBarWithNavController(navController = navController, configuration = appbarConfig)
    }
}