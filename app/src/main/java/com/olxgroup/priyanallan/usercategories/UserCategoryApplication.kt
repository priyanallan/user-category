package com.olxgroup.priyanallan.usercategories

import android.app.Application
import com.olxgroup.priyanallan.usercategories.repository.local.LocalDataRepository
import com.olxgroup.priyanallan.usercategories.repository.remote.ApiModule
import com.olxgroup.priyanallan.usercategories.repository.remote.RemoteDataRepository
import com.olxgroup.priyanallan.usercategories.viewmodel.CategoryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Main Application
 */
class UserCategoryApplication : Application() {

    //Koin Modules
    private val apiModule = module {
        single {
            ApiModule.getInstance(applicationContext)
        }

        viewModel {
            CategoryViewModel(get())
        }
    }

    private val remoteDataRepository = module {
        single {
            RemoteDataRepository()
        }
    }

    private val localDataRepository = module {
        single {
            LocalDataRepository(applicationContext)
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UserCategoryApplication)
            modules(
                listOf(
                    apiModule,
                    remoteDataRepository,
                    localDataRepository
                )
            )
        }
    }

}