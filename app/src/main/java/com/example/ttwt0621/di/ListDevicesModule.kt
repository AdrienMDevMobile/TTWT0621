package com.example.ttwt0621.di

import com.example.ttwt0621.apiCall.IListGetter
import com.example.ttwt0621.apiCall.VolleyListGetter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ListDevicesModule {

    @ViewModelScoped
    @Binds
    abstract fun bindListGetter(
        list: VolleyListGetter
    ) : IListGetter

}