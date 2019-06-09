package com.olxgroup.priyanallan.usercategories.repository.local

import android.content.Context
import com.olxgroup.priyanallan.usercategories.R
import org.koin.core.KoinComponent

class LocalDataRepository(context: Context) : KoinComponent {

    companion object {

        const val PREF_IS_FIRST_RUN = "PREF_IS_FIRST_RUN"
    }

    private val preferences = context.getSharedPreferences(
        context.getString(R.string.preferences_file_name),
        Context.MODE_PRIVATE
    )

    fun isFirstRun(): Boolean {
        return preferences.getBoolean(PREF_IS_FIRST_RUN, true)
    }

    fun setIsFirstRun(isFirstRun: Boolean) {
        preferences.edit().putBoolean(PREF_IS_FIRST_RUN, isFirstRun).apply()
    }

}