package com.sena.movieapp.screen.employee

import com.sena.movieapp.base.model.EmployeeResponse
import javax.inject.Inject

class EmployeeRemoteDataSource @Inject constructor (private val service: EmployeeService) {

    suspend fun fetchEmployeeList(): EmployeeResponse = service.getEmployeeList()
}