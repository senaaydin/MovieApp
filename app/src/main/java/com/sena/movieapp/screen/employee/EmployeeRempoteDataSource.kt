package com.sena.movieapp.screen.employee

import com.sena.movieapp.base.model.EmployeeResponse

class EmployeeRemoteDataSource(private val service: EmployeeService) {

    suspend fun fetchEmployeeList(): EmployeeResponse = service.getEmployeeList()
}