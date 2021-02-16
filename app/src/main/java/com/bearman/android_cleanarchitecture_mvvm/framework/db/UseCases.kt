package com.bearman.android_cleanarchitecture_mvvm.framework.db

import com.bearman.core.usecase.AddNoteUseCase
import com.bearman.core.usecase.GetAllNotesUseCase
import com.bearman.core.usecase.GetNoteUseCase
import com.bearman.core.usecase.RemoveNoteUseCase

data class UseCases(
    val addNote: AddNoteUseCase,
    val getAllNotes: GetAllNotesUseCase,
    val getNote: GetNoteUseCase,
    val removeNote: RemoveNoteUseCase
)