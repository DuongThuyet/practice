package com.billandbros.metrip.presentation.base.mvp.view

interface ViewSupportError {
    fun showError(errorMsg: String)
    fun hideError()
}