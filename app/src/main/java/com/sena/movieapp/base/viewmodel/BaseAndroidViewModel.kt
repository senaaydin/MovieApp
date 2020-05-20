package com.sena.movieapp.base.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sena.movieapp.R
import com.sena.movieapp.base.usecase.Failure
import com.sena.movieapp.base.view.PopUpType
import com.sena.movieapp.base.view.PopupUiModel

@Suppress("ConvertSecondaryConstructorToPrimary")
@SuppressLint("StaticFieldLeak")
abstract class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {

    private val _failurePopup = MutableLiveData<Event<PopupUiModel>>()
    val failurePopup: LiveData<Event<PopupUiModel>> = _failurePopup

    private val _success = MutableLiveData<Event<String>>()
    val success: LiveData<Event<String>> = _success

    protected open fun handleFailure(failure: Failure) {
        val (title, message) = when (failure) {
            is Failure.NoConnectivityError -> Pair(
                "",
                getString(R.string.common_error_network_connection)
            )
            is Failure.UnknownHostError -> Pair("", getString(R.string.common_error_unknown_host))
            is Failure.ServerError -> Pair("", failure.message)
            is Failure.JsonError, is Failure.EmptyResponse -> Pair(
                "",
                getString(R.string.common_error_invalid_response)
            )
            is Failure.FormValidationError -> Pair(
                getString(R.string.common_title_popup_form_validation), failure.message
                    ?: getString(R.string.common_error_invalid_form)
            )
            is Failure.IoError -> Pair("", getString(R.string.common_error_can_not_save_data))
            is Failure.UnknownError -> Pair(
                "",
                failure.exception.localizedMessage ?: getString(R.string.common_error_unknown)
            )
            is Failure.HttpError -> Pair(
                "",
                getString(R.string.common_error_http, failure.code.toString())
            )
            is Failure.TimeOutError -> Pair("", getString(R.string.common_error_timeout))
            else -> Pair("", failure.message ?: failure.toString())
        }

        _failurePopup.value = Event(
            PopupUiModel(
                title = title,
                message = message,
                popUpType = PopUpType.ERROR
            )
        )
    }

    protected fun showSnackBar(message: String) {
        _success.value = Event(message)
    }

    protected fun getString(@StringRes resId: Int): String {
        return getApplication<Application>().getString(resId)
    }

    protected fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return getApplication<Application>().getString(resId, formatArgs)
    }

    override fun onCleared() {
        super.onCleared()
    }
}