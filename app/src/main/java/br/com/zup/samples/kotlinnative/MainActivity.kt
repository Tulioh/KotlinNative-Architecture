package br.com.zup.samples.kotlinnative

import android.os.Bundle
import br.com.zup.samples.kotlinnative.base.BaseActivity
import br.com.zup.samples.kotlinnative.di.provideHomePresenter
import br.com.zup.samples.kotlinnative.feature.home.presenter.HomePresenter
import br.com.zup.samples.kotlinnative.feature.home.presenter.HomeView
import br.com.zup.samples.kotlinnative.feature.home.viewstate.HomePresentation
import kotlinx.android.synthetic.main.activity_main.*
import sample.R

class MainActivity : BaseActivity<HomePresenter>(), HomeView {

    override fun getLayoutId(): Int? = R.layout.activity_main

    override fun getPresenterInstance(): HomePresenter = provideHomePresenter(this)

    override fun initialize(savedInstanceState: Bundle?) {
        button.setOnClickListener {
            presenter.onClickGetMovies()
        }
    }

    override fun onHomePresentationListUpdated(homePresentationList: List<HomePresentation>) {
        print(homePresentationList)
    }

    override fun onErrorThrown(throwable: Throwable) {
        TODO("not implemented")
    }
}