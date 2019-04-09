package br.com.zup.samples.kotlinnative.feature.home.di

import br.com.zup.samples.kotlinnative.data.MovieRepository
import br.com.zup.samples.kotlinnative.di.repositoryDI
import br.com.zup.samples.kotlinnative.feature.home.converter.HomePresentationConverter
import br.com.zup.samples.kotlinnative.feature.home.viewmodel.HomeViewModel
import com.github.jeremyrempel.unsplash.di.networkDI
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider

val homeDI = Kodein {
    import(repositoryDI)

    bind<HomePresentationConverter>() with provider { HomePresentationConverter() }

    bind<HomeViewModel>() with provider {
        val movieRepository by kodein.instance<MovieRepository>()
        val converter by kodein.instance<HomePresentationConverter>()

        HomeViewModel(movieRepository, converter)
    }

}