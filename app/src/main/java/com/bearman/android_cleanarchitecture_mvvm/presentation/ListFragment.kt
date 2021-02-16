package com.bearman.android_cleanarchitecture_mvvm.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import com.bearman.android_cleanarchitecture_mvvm.R
import com.bearman.android_cleanarchitecture_mvvm.framework.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        Log.d("TEST", "ALL : ${viewModel.getAllNote()}")

        observerList()
        addNoteButton.setOnClickListener { goToNoteDetail() }
    }

    private fun goToNoteDetail(id: Long = 0L) {
        val action = ListFragmentDirections.actionGoToNote(id)
        Navigation.findNavController(noteListView).navigate(action)
    }

    private fun observerList() {
        viewModel.noteList.observe(this, Observer {
            Log.d("TEST", "ALL : $it")
        })
    }

}
