package com.example.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.feature.popular.PopularContract
import com.example.presentation.model.PopularKeywordsViewModel
import com.example.ui.adapter.RecyclerViewAdapter
import com.example.ui.model.ItemPopularViewHolderModel
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), PopularContract.View {

    private val presenter: PopularContract.Presenter by inject()
    private val adapter: RecyclerViewAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initConfigRv()
        presenter.attachView(this)
    }

    private fun initConfigRv() {
        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = RecyclerView.HORIZONTAL
        rvPopularKey.layoutManager = layoutManager
        rvPopularKey.adapter = adapter
    }


    override fun showDataValid(popularKeywordsViewModel: PopularKeywordsViewModel) {
        adapter.setData(
            ItemPopularViewHolderModel(
                listItem = popularKeywordsViewModel.keywords,
                isInitBg = popularKeywordsViewModel.isInitBgs
            )
        )
        adapter.notifyDataSetChanged()
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }

    override fun hideError() {
        // nothing to do
    }

    override fun showLoading() {
        pgBar.visibility = View.VISIBLE

    }

    override fun hideLoading() {
        pgBar.visibility = View.GONE
    }
}
