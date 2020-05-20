package com.sena.movieapp.screen.employee

import com.sena.movieapp.base.model.EmployeeInformation
import com.sena.movieapp.base.network.Dependency.employeeService
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val remoteDataSource: EmployeeRemoteDataSource
) {
    suspend fun fetchEmployee(): List<EmployeeInformation> {
        return remoteDataSource.fetchEmployeeList().data
    }
}