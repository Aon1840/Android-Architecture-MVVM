package com.bearman.core.usecase

import com.bearman.core.repository.NoteRepository

class GetAllNotesUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke() {
        repository.getAll()
    }
}