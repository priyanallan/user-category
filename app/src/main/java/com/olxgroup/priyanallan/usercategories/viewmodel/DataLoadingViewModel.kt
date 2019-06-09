package com.olxgroup.priyanallan.usercategories.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.lang.Appendable

/**
 * Extend this class to observe when async data loaded from network.
 */
open class DataLoadingViewModel(application: Application): AndroidViewModel(application) {

    var onDataLoadingFinished: MutableLiveData<String> = MutableLiveData()
}