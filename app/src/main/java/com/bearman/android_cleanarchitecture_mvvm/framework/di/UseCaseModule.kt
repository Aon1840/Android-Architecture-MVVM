package com.bearman.android_cleanarchitecture_mvvm.framework.di

import com.bearman.android_cleanarchitecture_mvvm.framework.db.UseCases
import com.bearman.core.repository.NoteRepository
import com.bearman.core.usecase.AddNoteUseCase
import com.bearman.core.usecase.GetAllNotesUseCase
import com.bearman.core.usecase.GetNoteUseCase
import com.bearman.core.usecase.RemoveNoteUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideUseCase(repository: NoteRepository) = UseCases(
        AddNoteUseCase(repository),
        GetAllNotesUseCase(repository),
        GetNoteUseCase(repository),
        RemoveNoteUseCase(repository)
    )
}