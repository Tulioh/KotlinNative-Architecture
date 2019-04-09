package br.com.zup.samples.kotlinnative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import br.com.zup.samples.kotlinnative.feature.home.di.homeDI
import br.com.zup.samples.kotlinnative.feature.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.github.florent37.livedata.observe
import org.kodein.di.erased.instance
import sample.R

class MainActivity : AppCompatActivity() {

    private val viewModel by homeDI.instance<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            viewModel.getMovies().observe(this as LifecycleOwner) { moviePresentationList ->
                print(moviePresentationList)
            }
        }
    }
}