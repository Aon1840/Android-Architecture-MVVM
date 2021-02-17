package com.bearman.android_cleanarchitecture_mvvm.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bearman.android_cleanarchitecture_mvvm.framework.db.RoomNoteDataSource
import com.bearman.android_cleanarchitecture_mvvm.framework.db.UseCases
import com.bearman.core.data.Note
import com.bearman.core.repository.NoteRepository
import com.bearman.core.usecase.AddNoteUseCase
import com.bearman.core.usecase.GetAllNotesUseCase
import com.bearman.core.usecase.GetNoteUseCase
import com.bearman.core.usecase.RemoveNoteUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = UseCases(
        AddNoteUseCase(repository),
        GetAllNotesUseCase(repository),
        GetNoteUseCase(repository),
        RemoveNoteUseCase(repository)
    )

    val saved = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }

    fun getNote(id: Long) {
        coroutineScope.launch {
            currentNote.postValue(useCases.getNote(id))
        }
    }
}