package com.olxgroup.priyanallan.usercategories.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.olxgroup.priyanallan.usercategories.R
import com.olxgroup.priyanallan.usercategories.viewmodel.CategoryViewModel
import org.koin.android.viewmodel.ext.android.viewModel

import org.koin.core.KoinComponent

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HistoryFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HistoryFragment : Fragment(), KoinComponent {

    val categoryViewModel by viewModel<CategoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryViewModel.categoryTypes.observe(this, Observer {
            Log.d("Category", it[0].author)
        })
        categoryViewModel.getCategories(6)
    }
}