package com.bearman.core.usecase

import com.bearman.core.data.Note
import com.bearman.core.repository.NoteRepository

class GetAllNotesUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(): List<Note> {
        return repository.getAll()
    }
}