@file:OptIn(KoinReflectAPI::class)

package com.bluelampcreative.udfdemo.di

import com.bluelampcreative.udfdemo.ui.views.moviesearch.MovieSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.annotation.KoinReflectAPI
import org.koin.dsl.module


val appModule = module {

    viewModel<MovieSearchViewModel>()

}