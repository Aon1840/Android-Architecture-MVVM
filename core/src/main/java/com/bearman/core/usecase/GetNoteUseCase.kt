package com.bearman.core.usecase

import com.bearman.core.data.Note
import com.bearman.core.repository.NoteRepository

class GetNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Long): Note? {
        return repository.get(id)
    }
}