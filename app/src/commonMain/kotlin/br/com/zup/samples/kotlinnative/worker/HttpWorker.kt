package br.com.zup.samples.kotlinnative.worker

import br.com.zup.samples.kotlinnative.data.entity.MovieResultsEntity
import br.com.zup.samples.kotlinnative.util.LogLevel
import br.com.zup.samples.kotlinnative.util.log
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.http.HeadersBuilder
import io.ktor.http.HttpMethod
import io.ktor.http.takeFrom

class HttpWorker(private val httpClient: HttpClient, private val baseUrl: String) {

    companion object {
        internal val TAG = HttpWorker::class.toString()
    }

    suspend fun doGet(request: HttpRequest): MovieResultsEntity = httpClient.get {
        fromHttpRequest(request)
    }

    /*suspend fun <T> doPost(request: HttpRequest): T = httpClient.post {
        fromHttpRequest(request)
    }

    suspend fun <T> doPut(request: HttpRequest): T = httpClient.put {
        fromHttpRequest(request)
    }

    suspend fun <T> doDelete(request: HttpRequest): T = httpClient.delete {
        fromHttpRequest(request)
    }*/

    private fun HttpRequestBuilder.fromHttpRequest(request: HttpRequest) {
        logMessage(request)
        getHttpMethod(request.method)
        getHttpHeaders(request.headers)
        url {
            takeFrom(baseUrl)
            encodedPath = request.path
        }
    }

    private fun getHttpMethod(requestMethod: br.com.zup.samples.kotlinnative.worker.HttpMethod): HttpMethod {
        return when(requestMethod) {
            br.com.zup.samples.kotlinnative.worker.HttpMethod.GET -> HttpMethod.Get
            br.com.zup.samples.kotlinnative.worker.HttpMethod.POST -> HttpMethod.Post
            br.com.zup.samples.kotlinnative.worker.HttpMethod.PUT -> HttpMethod.Put
            else -> HttpMethod.Delete
        }
    }

    private fun getHttpHeaders(headers: Map<String, String>?): HeadersBuilder {
        val headersBuilder = HeadersBuilder()

        if (headers != null) {
            for ((key, value) in headers) {
                headersBuilder.append(key, value)
            }
        }

        return headersBuilder
    }

    private fun logMessage(request: HttpRequest) {
        val message = "${request.method} Request at $baseUrl${request.path} with headers: ${request.headers} and body: ${request.body}"
        log(LogLevel.DEBUG, TAG, message)
    }
}