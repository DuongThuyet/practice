package com.example.presentation.feature.popular

import com.example.domain.usecase.GetPopularKeyWordsUseCase
import com.example.presentation.mapper.PopularKeywordsViewModelMapper
import io.reactivex.observers.DisposableSingleObserver

class PopularPresenter(
    private val getPopularKeyWordsUseCase: GetPopularKeyWordsUseCase,
    private val popularKeywordsViewModelMapper: PopularKeywordsViewModelMapper
) : PopularContract.Presenter() {


    override fun onAttachView() {
        super.onAttachView()
        loadData()
    }

    override fun loadData() {
        view?.let { view ->
            getPopularKeyWordsUseCase.cancel()
            view.showLoading()
            getPopularKeyWordsUseCase.execute(object : DisposableSingleObserver<List<String?>?>() {
                override fun onSuccess(t: List<String?>) {
                    view.hideLoading()
                    view.showDataValid(popularKeywordsViewModelMapper.map(t))
                }

                override fun onError(e: Throwable) {
                    view.hideLoading()
                    view.showError("Get data fail, Pls try again")
                }
            })
        }
    }

    override fun onDetachView() {
        getPopularKeyWordsUseCase.cancel()
        super.onDetachView()

    }
}