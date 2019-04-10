package br.com.zup.samples.kotlinnative.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : BasePresenter> : AppCompatActivity() {

    protected abstract fun getLayoutId(): Int?
    protected abstract fun getPresenterInstance(): T
    protected abstract fun initialize(savedInstanceState: Bundle?)

    protected lateinit var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = getPresenterInstance()

        if (getLayoutId() != null) {
            setContentView(getLayoutId()!!)
        }

        initialize(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onCleared()
    }
}