package com.sena.movieapp.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sena.movieapp.screen.detail.MovieDetailViewModel
import com.sena.movieapp.screen.employee.EmployeeViewModel
import com.sena.movieapp.screen.movie.MovieViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(EmployeeViewModel::class)
    internal abstract fun provideEmployeeViewModel(viewModel: EmployeeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindsMovieViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindsMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel

}


@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("Unknown model class: $modelClass")
        }
        return try {
            creator.get() as T
        }catch(e:Exception){
            throw RuntimeException(e)
        }
    }
}

@MapKey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)