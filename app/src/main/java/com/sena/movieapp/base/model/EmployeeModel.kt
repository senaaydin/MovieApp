package com.sena.movieapp.base.model

import com.squareup.moshi.Json
import java.io.Serializable

data class EmployeeResponse(
    @Json(name = "data")
    val `data`: List<EmployeeInformation>,
    @Json(name = "status")
    val status: String?
): Serializable

data class EmployeeInformation(
    @Json(name = "employee_age")
    val employeeAge: String?,
    @Json(name = "employee_name")
    val employeeName: String?,
    @Json(name = "employee_salary")
    val employeeSalary: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "profile_image")
    val profileImage: String?
): Serializable