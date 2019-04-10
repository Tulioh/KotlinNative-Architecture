package br.com.zup.samples.kotlinnative.di

import br.com.zup.samples.kotlinnative.data.MovieRepository
import br.com.zup.samples.kotlinnative.feature.home.converter.HomePresentationConverter
import br.com.zup.samples.kotlinnative.feature.home.di.homeDI
import br.com.zup.samples.kotlinnative.feature.home.presenter.HomePresenter
import br.com.zup.samples.kotlinnative.feature.home.presenter.HomeView
import org.kodein.di.direct
import org.kodein.di.erased.instance

fun provideHomePresenter(homeView: HomeView) = HomePresenter(
    homeView,
    homeDI.direct.instance<MovieRepository>(),
    homeDI.direct.instance<HomePresentationConverter>()
)