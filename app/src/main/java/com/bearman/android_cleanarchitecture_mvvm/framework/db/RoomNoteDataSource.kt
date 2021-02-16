package com.bearman.android_cleanarchitecture_mvvm.framework.db

import android.content.Context
import com.bearman.core.data.Note
import com.bearman.core.repository.NoteDataSource

class RoomNoteDataSource(context: Context) : NoteDataSource {

    private val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) {
        noteDao.addNoteEntity(NoteEntity.fromNote(note))
    }

    override suspend fun get(id: Long): Note? {
        return noteDao.getNoteEntity(id)?.toNote()
    }

    override suspend fun getAll(): List<Note> {
        return noteDao.getAllNoteEntities().map { it.toNote() }
    }

    override suspend fun remove(note: Note) {
        return noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
    }
}