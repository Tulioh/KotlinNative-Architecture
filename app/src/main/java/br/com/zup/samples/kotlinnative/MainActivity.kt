package br.com.zup.samples.kotlinnative

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import br.com.zup.samples.kotlinnative.base.BaseActivity
import br.com.zup.samples.kotlinnative.feature.home.di.homeDI
import br.com.zup.samples.kotlinnative.feature.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.github.florent37.livedata.observe
import org.kodein.di.direct
import org.kodein.di.erased.instance
import sample.R

class MainActivity : BaseActivity<HomeViewModel>() {

    override fun getLayoutId(): Int? = R.layout.activity_main

    override fun getViewModelInstance(): HomeViewModel = homeDI.direct.instance()

    override fun initialize(savedInstanceState: Bundle?) {
        button.setOnClickListener {
            viewModel.getMovies().observe(this as LifecycleOwner) { moviePresentationList ->
                print(moviePresentationList)
            }
        }
    }
}