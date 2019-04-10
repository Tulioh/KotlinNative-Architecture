package br.com.zup.samples.kotlinnative.feature.home.presenter

import br.com.zup.samples.kotlinnative.base.BaseView
import br.com.zup.samples.kotlinnative.feature.home.viewstate.HomePresentation

interface HomeView : BaseView {

    fun onHomePresentationListUpdated(homePresentationList: List<HomePresentation>)

}