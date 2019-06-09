package com.olxgroup.priyanallan.usercategories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.olxgroup.priyanallan.usercategories.repository.local.LocalDataRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainActivity : AppCompatActivity(), KoinComponent {

    private val localDataRepository by inject<LocalDataRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.nav_graph)

        localDataRepository.apply {
            if (isFirstRun()) {
                navGraph.startDestination = R.id.categoryFragment
                setIsFirstRun(false)
            } else {
                navGraph.startDestination = R.id.historyFragment
            }
        }

        navController.graph = navGraph
    }
}