package com.bearman.core.usecase

import com.bearman.core.data.Note
import com.bearman.core.repository.NoteRepository

class RemoveNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) = repository.remove(note)
}