package com.sena.movieapp.screen.employee

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sena.movieapp.base.model.EmployeeInformation
import com.sena.movieapp.base.usecase.UseCase
import com.sena.movieapp.base.viewmodel.BaseAndroidViewModel
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application) : BaseAndroidViewModel(application) {
    private val usaCase: FetchEmployeeUsaCase = FetchEmployeeUsaCase()

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