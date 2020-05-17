package com.sena.movieapp.screen.employee

import com.sena.movieapp.base.model.EmployeeInformation
import com.sena.movieapp.base.network.Dependency.employeeService

class EmployeeRepository(
    private val remoteDataSource: EmployeeRemoteDataSource = EmployeeRemoteDataSource(employeeService)
) {
    suspend fun fetchEmployee(): List<EmployeeInformation> {
        return remoteDataSource.fetchEmployeeList().data
    }
}