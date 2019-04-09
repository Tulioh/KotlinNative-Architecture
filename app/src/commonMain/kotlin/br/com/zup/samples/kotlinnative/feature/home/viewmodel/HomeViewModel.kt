package br.com.zup.samples.kotlinnative.feature.home.viewmodel

import br.com.zup.samples.kotlinnative.data.MovieRepository
import br.com.zup.samples.kotlinnative.feature.home.converter.HomePresentationConverter
import br.com.zup.samples.kotlinnative.feature.home.presentation.HomePresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.github.florent37.livedata.KLiveData
import com.github.florent37.livedata.KMutableLiveData

class HomeViewModel(private val movieRepository: MovieRepository, private val converter: HomePresentationConverter) {

    fun getMovies() : KLiveData<List<HomePresentation>> {
        val homePresentation = KMutableLiveData<List<HomePresentation>>()

        GlobalScope.apply {
            launch(Dispatchers.Main) {
                val movieEntityList = movieRepository.getMoviesBy("batman")
                homePresentation.value = converter.convert(movieEntityList)
            }
        }

        return homePresentation
    }

}