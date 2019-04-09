package br.com.zup.samples.kotlinnative.data

import br.com.zup.samples.kotlinnative.data.entity.MovieResultsEntity
import br.com.zup.samples.kotlinnative.data.remote.movie.MovieApi

class MovieRepository(private val movieApi: MovieApi) {

    suspend fun getMoviesBy(name: String): List<MovieResultsEntity.MovieEntity> = movieApi.getMoviesBy(name)

}