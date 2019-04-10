package br.com.zup.samples.kotlinnative.feature.home.presenter

import br.com.zup.samples.kotlinnative.base.BasePresenter
import br.com.zup.samples.kotlinnative.data.MovieRepository
import br.com.zup.samples.kotlinnative.feature.home.converter.HomePresentationConverter
import br.com.zup.samples.kotlinnative.util.*

class HomePresenter(private val viewHome: HomeView,
                    private val movieRepository: MovieRepository,
                    private val converter: HomePresentationConverter): BasePresenter(viewHome) {

    fun onClickGetMovies() {
        launch(getMainDispetcher(), this::onErrorThrown) {
            val movieEntityList = movieRepository.getMoviesBy("batman")
            viewHome.onHomePresentationListUpdated(converter.convert(movieEntityList))
        }
    }
}