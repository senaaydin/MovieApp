package com.sena.movieapp.screen.employee

import com.sena.movieapp.base.model.EmployeeResponse
import retrofit2.http.GET

interface EmployeeService {

    @GET("employees")
    suspend fun getEmployeeList(): EmployeeResponse
}