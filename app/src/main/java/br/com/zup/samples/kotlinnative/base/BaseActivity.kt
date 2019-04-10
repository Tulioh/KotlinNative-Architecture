package br.com.zup.samples.kotlinnative.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    protected abstract fun getLayoutId(): Int?
    protected abstract fun getViewModelInstance(): T
    protected abstract fun initialize(savedInstanceState: Bundle?)

    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModelInstance()

        if (getLayoutId() != null) {
            setContentView(getLayoutId()!!)
        }

        initialize(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.onCleared()
    }
}