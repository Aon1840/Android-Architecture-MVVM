package com.bearman.android_cleanarchitecture_mvvm.framework.di

import com.bearman.android_cleanarchitecture_mvvm.framework.ListViewModel
import com.bearman.android_cleanarchitecture_mvvm.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCaseModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}