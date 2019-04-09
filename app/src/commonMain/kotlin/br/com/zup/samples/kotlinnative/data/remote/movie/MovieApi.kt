package br.com.zup.samples.kotlinnative.data.remote.movie

import br.com.zup.samples.kotlinnative.data.entity.MovieResultsEntity.MovieEntity

interface MovieApi {

    suspend fun getMoviesBy(name: String): List<MovieEntity>

}