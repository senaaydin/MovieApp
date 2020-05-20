package com.sena.movieapp.screen.employee

import com.sena.movieapp.base.model.EmployeeInformation
import com.sena.movieapp.base.usecase.UseCase
import javax.inject.Inject

class FetchEmployeeUsaCase @Inject constructor(
    private val repository: EmployeeRepository
) : UseCase<List<EmployeeInformation>, UseCase.None>() {

    override suspend fun buildUseCase(params: UseCase.None): List<EmployeeInformation> {
        return repository.fetchEmployee()
    }
}