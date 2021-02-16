package com.bearman.android_cleanarchitecture_mvvm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.bearman.android_cleanarchitecture_mvvm.R
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNoteButton.setOnClickListener { goToNoteDetail() }
    }

    private fun goToNoteDetail(id: Long = 0L) {
        val action = ListFragmentDirections.actionGoToNote(id)
        Navigation.findNavController(noteListView).navigate(action)
    }

}
