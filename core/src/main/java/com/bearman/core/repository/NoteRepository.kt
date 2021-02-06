package com.bearman.core.repository

import com.bearman.core.data.Note

class NoteRepository(
    private val noteDataSource: NoteDataSource
) {

    suspend fun addNote(note: Note) {
        noteDataSource.add(note)
    }

    suspend fun get(id: Long): Note? {
        return noteDataSource.get(id)
    }

    suspend fun getAll(): List<Note> {
        return noteDataSource.getAll()
    }

    suspend fun remove(note: Note) {
        noteDataSource.remove(note)
    }
}