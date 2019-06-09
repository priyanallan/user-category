package com.olxgroup.priyanallan.usercategories.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.olxgroup.priyanallan.usercategories.repository.model.ImageCategory
import com.olxgroup.priyanallan.usercategories.repository.remote.RemoteDataRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Viewmodel for the views that handle user categories
 *
 * - Retrieve category data from the API
 */
class CategoryViewModel(application: Application) : DataLoadingViewModel(application),
    KoinComponent {

    var categoryTypes: MutableLiveData<List<ImageCategory>> = MutableLiveData()

    val remoteDataRepository by inject<RemoteDataRepository>()

    fun getCategories(limit: Int) {
        remoteDataRepository.getImageCategories(
            limit,
            object : RemoteDataRepository.ApiRequestCallback<List<ImageCategory>> {
                override fun onApiRequestSucceeded(content: List<ImageCategory>?) {
                    categoryTypes.value = content
                    onDataLoadingFinished.value = ""
                }

                override fun onApiRequestFailed(reason: String) {
                    onDataLoadingFinished.value = reason
                }

            })
    }
}
