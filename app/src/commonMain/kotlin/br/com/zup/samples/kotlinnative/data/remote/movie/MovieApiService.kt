package br.com.zup.samples.kotlinnative.data.remote.movie

import br.com.zup.samples.kotlinnative.data.entity.MovieResultsEntity.MovieEntity
import br.com.zup.samples.kotlinnative.util.LogLevel
import br.com.zup.samples.kotlinnative.util.log
import br.com.zup.samples.kotlinnative.worker.HttpMethod
import br.com.zup.samples.kotlinnative.worker.HttpRequest
import br.com.zup.samples.kotlinnative.worker.HttpWorker

class MovieApiService(private val httpWorker: HttpWorker): MovieApi {

    override suspend fun getMoviesBy(name: String): List<MovieEntity> {
        val request = HttpRequest(
            path = "/?s=$name&apikey=2be5a92a",
            method = HttpMethod.GET
        )
        log(LogLevel.DEBUG, "MovieApiService", "httpWorker.doGet")
        val response = httpWorker.doGet(request).search
        return response ?: emptyList()
    }

}