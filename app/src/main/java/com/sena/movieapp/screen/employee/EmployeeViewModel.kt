package com.sena.movieapp.screen.employee

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sena.movieapp.base.model.EmployeeInformation
import com.sena.movieapp.base.usecase.UseCase
import com.sena.movieapp.base.viewmodel.BaseAndroidViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmployeeViewModel @Inject constructor (application: Application) : BaseAndroidViewModel(application) {
    @Inject
    lateinit var usaCase: FetchEmployeeUsaCase

    val employeeList = MutableLiveData<List<EmployeeInformation>>()

    fun fetchEmployeeViewModel() {
        viewModelScope.launch {
            val response = usaCase.run(UseCase.None)
            response.either(::handleFailure, ::postEmployeeList)
        }
    }

    private fun postEmployeeList(employeeInformation: List<EmployeeInformation>) {
        employeeList.value = employeeInformation
    }
}