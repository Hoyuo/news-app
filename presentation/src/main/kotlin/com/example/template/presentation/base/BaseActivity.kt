package com.example.template.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel<E>, E : BaseEvent>(
    private val bindingInflater: (layoutInflater: LayoutInflater) -> B,
) : AppCompatActivity() {

    protected lateinit var binding: B
        private set
    protected abstract val viewModel: VM

    protected abstract fun viewModelVariableId(): Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingInflater(layoutInflater)
        setContentView(binding.root)

        bind {
            lifecycleOwner = this@BaseActivity
            viewModelVariableId()?.let { variableId ->
                setVariable(variableId, viewModel)
            }
        }

        initViews()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewEvent.collectLatest {
                    it?.let { initEventObserver(it) }
                    viewModel.clearEvent()
                }
            }
        }
    }

    abstract fun initViews()

    abstract fun initEventObserver(event: E)

    protected fun bind(block: B.() -> Unit) {
        binding.run(block)
    }
}
