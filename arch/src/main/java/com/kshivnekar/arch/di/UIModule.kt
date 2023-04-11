package com.kshivnekar.arch.di

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class UIModule {

    @Provides
    fun providePicasso():Picasso {
        return Picasso.get()
    }
}