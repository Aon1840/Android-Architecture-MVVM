package com.bearman.android_cleanarchitecture_mvvm.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bearman.android_cleanarchitecture_mvvm.framework.db.UseCases
import com.bearman.android_cleanarchitecture_mvvm.framework.di.ApplicationModule
import com.bearman.android_cleanarchitecture_mvvm.framework.di.DaggerViewModelComponent
import com.bearman.core.data.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    @Inject
    lateinit var useCases: UseCases

    val noteList = MutableLiveData<List<Note>>()

    fun getAllNote() {
        coroutineScope.launch {
            noteList.postValue(useCases.getAllNotes())
        }
    }
}