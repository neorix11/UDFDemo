package com.bluelampcreative.data.di

import com.bluelampcreative.data.networking.createHttpClient
import com.bluelampcreative.data.repositories.MovieRepository
import com.bluelampcreative.domain.repositories.IMovieRepository
import com.bluelampcreative.domain.usecases.MovieSearchUC
import org.koin.dsl.module

val dataModule = module {

    single { MovieSearchUC(get()) }
    single<IMovieRepository> { MovieRepository(createHttpClient())}
}