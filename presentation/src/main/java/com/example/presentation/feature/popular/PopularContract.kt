package com.example.presentation.feature.popular

import com.billandbros.metrip.presentation.base.mvp.PresenterMvp
import com.billandbros.metrip.presentation.base.mvp.ViewMvp
import com.billandbros.metrip.presentation.base.mvp.view.ViewSupportError
import com.billandbros.metrip.presentation.base.mvp.view.ViewSupportLoading
import com.example.presentation.model.PopularKeywordsViewModel

interface PopularContract {

    interface View : ViewMvp, ViewSupportError, ViewSupportLoading {
        fun showDataValid(popularKeywordsViewModel: PopularKeywordsViewModel)
    }

    abstract class Presenter : PresenterMvp<View>() {
        abstract fun loadData()
    }

}