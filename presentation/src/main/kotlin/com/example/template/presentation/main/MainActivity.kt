package com.example.template.presentation.main

import androidx.activity.viewModels
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.template.presentation.BR
import com.example.template.presentation.base.BaseActivity
import com.example.template.presentation.databinding.ActivityMainBinding
import com.example.template.presentation.main.adapter.HeadlineAdapter
import com.example.template.presentation.web.WebViewActivityHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel, MainEvent>(
    ActivityMainBinding::inflate,
) {

    override val viewModel: MainViewModel by viewModels()
    override fun viewModelVariableId() = BR.viewModel

    override fun initViews() {
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)

        binding.recyclerView.adapter = HeadlineAdapter {
            viewModel.onArticleClicked(it)
        }
        binding.recyclerView.itemAnimator = null
    }

    override fun initEventObserver(event: MainEvent) {
        when (event) {
            is MainEvent.NavigateToWeb -> {
                WebViewActivityHelper.getIntent(this, event.url)
                    .let(::startActivity)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getArticleList()
    }
}
