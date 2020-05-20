package com.sena.movieapp.base.di

import android.app.Application
import com.sena.movieapp.screen.employee.EmployeeActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        ViewModelModule::class
    ])


interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
    fun inject(activity: EmployeeActivity)
}
//
//internal interface AppComponentt : AndroidInjector<DaggerApplication> {
//
//    @Component.Builder
//    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
//}