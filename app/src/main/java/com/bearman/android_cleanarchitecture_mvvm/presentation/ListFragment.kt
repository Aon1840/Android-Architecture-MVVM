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
import androidx.recyclerview.widget.LinearLayoutManager

import com.bearman.android_cleanarchitecture_mvvm.R
import com.bearman.android_cleanarchitecture_mvvm.framework.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private val notesListAdapter = NoteListAdapter(arrayListOf())
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteListView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesListAdapter
        }

        addNoteButton.setOnClickListener { goToNoteDetail() }

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        observerList()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllNote()
    }

    private fun goToNoteDetail(id: Long = 0L) {
        val action = ListFragmentDirections.actionGoToNote(id)
        Navigation.findNavController(noteListView).navigate(action)
    }

    private fun observerList() {
        viewModel.noteList.observe(this, Observer { noteList ->
            loadingView.visibility = View.GONE
            noteListView.visibility = View.VISIBLE
            notesListAdapter.updateNote(noteList.sortedByDescending { it.updateTime })
        })
    }

}
