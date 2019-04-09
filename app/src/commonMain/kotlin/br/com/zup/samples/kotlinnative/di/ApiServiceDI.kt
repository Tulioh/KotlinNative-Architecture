package br.com.zup.samples.kotlinnative.di

import br.com.zup.samples.kotlinnative.data.remote.movie.MovieApi
import br.com.zup.samples.kotlinnative.data.remote.movie.MovieApiService
import br.com.zup.samples.kotlinnative.worker.HttpWorker
import com.github.jeremyrempel.unsplash.di.networkDI
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider

val apiServiceDI = Kodein.Module("ApiServiceDI") {
    import(networkDI)

    bind<MovieApi>() with provider {
        val httpWorker by kodein.instance<HttpWorker>()

        MovieApiService(httpWorker)
    }

}