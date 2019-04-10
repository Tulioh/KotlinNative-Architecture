package br.com.zup.samples.kotlinnative.feature.home.di

import br.com.zup.samples.kotlinnative.di.repositoryDI
import br.com.zup.samples.kotlinnative.feature.home.converter.HomePresentationConverter
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.provider

val homeDI = Kodein {
    import(repositoryDI)

    bind<HomePresentationConverter>() with provider { HomePresentationConverter() }

}