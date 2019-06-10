package com.olxgroup.priyanallan.usercategories.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.olxgroup.priyanallan.usercategories.R

/**
 * A simple [Fragment] subclass.
 *
 */
class CatgoryItemsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_items, container, false)
    }

}
