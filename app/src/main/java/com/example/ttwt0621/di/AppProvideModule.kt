package com.example.ttwt0621.di

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object  AppProvideModule {

    @Singleton
    @Provides
    fun provideQueue(
        @ApplicationContext context : Context
    ): RequestQueue {
        return Volley.newRequestQueue(context)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

}