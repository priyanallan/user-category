package com.olxgroup.priyanallan.usercategories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.olxgroup.priyanallan.usercategories.repository.local.LocalDataRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainActivity : AppCompatActivity(), KoinComponent {

    private val localDataRepository by inject<LocalDataRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        localDataRepository.apply {
            if (isFirstRun()) {
                setIsFirstRun(false)
            }
        }
    }
}