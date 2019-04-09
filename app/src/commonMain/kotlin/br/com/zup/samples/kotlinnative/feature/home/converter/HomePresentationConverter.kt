package br.com.zup.samples.kotlinnative.feature.home.converter

import br.com.zup.samples.kotlinnative.data.entity.MovieResultsEntity
import br.com.zup.samples.kotlinnative.feature.home.presentation.HomePresentation

class HomePresentationConverter {

    fun convert(movieEntityList: List<MovieResultsEntity.MovieEntity>) : List<HomePresentation> {
        return movieEntityList.filter {
            it.poster != null
        }.map {
            HomePresentation(it.poster!!)
        }
    }

}