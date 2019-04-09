package br.com.zup.samples.kotlinnative.di

import br.com.zup.samples.kotlinnative.data.MovieRepository
import br.com.zup.samples.kotlinnative.data.remote.movie.MovieApi
import com.github.jeremyrempel.unsplash.di.networkDI
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.provider

val repositoryDI = Kodein.Module("RepositoryDI") {
    import(apiServiceDI)

    bind<MovieRepository>() with provider {
        val movieApi by kodein.instance<MovieApi>()

        MovieRepository(movieApi)
    }

}