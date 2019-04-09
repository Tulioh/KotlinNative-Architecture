package com.github.jeremyrempel.unsplash.di

import br.com.zup.samples.kotlinnative.data.entity.MovieResultsEntity
import br.com.zup.samples.kotlinnative.worker.HttpWorker
import io.ktor.client.HttpClient
import io.ktor.client.features.ExpectSuccess
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.JSON
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider

const val API_HOST = "API_HOST"
const val API_KEY = "API_KEY"

val networkDI = Kodein.Module("NetworkyDI") {
    bind<String>(API_HOST) with provider { "http://www.omdbapi.com" }
    bind<String>(API_KEY) with provider { "2be5a92a" }

    bind<HttpClient>() with provider {
        HttpClient {

            install(JsonFeature) {
                serializer = KotlinxSerializer(JSON.nonstrict).apply {
                    setMapper(MovieResultsEntity::class, MovieResultsEntity.serializer())
                }

            }
            install(ExpectSuccess)
        }

    }

    bind<HttpWorker>() with provider {
        val httpClient by kodein.instance<HttpClient>()
        val apiHost by kodein.instance<String>(API_HOST)

        HttpWorker(httpClient, apiHost)
    }
}