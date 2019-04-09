package br.com.zup.samples.kotlinnative.di

import br.com.zup.samples.kotlinnative.feature.home.di.homeDI
import br.com.zup.samples.kotlinnative.feature.home.viewmodel.HomeViewModel
import org.kodein.di.erased.instance

val homeViewModel : HomeViewModel by homeDI.instance()