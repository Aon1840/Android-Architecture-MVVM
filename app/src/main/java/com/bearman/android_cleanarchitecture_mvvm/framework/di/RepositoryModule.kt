package com.bearman.android_cleanarchitecture_mvvm.framework.di

import android.app.Application
import com.bearman.android_cleanarchitecture_mvvm.framework.db.RoomNoteDataSource
import com.bearman.core.repository.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))

}