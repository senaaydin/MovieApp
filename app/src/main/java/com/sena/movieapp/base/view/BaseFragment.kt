package com.sena.movieapp.base.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sena.movieapp.base.lazyThreadSafetyNone
import com.sena.movieapp.base.viewmodel.BaseAndroidViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VM : BaseAndroidViewModel> : Fragment() {

    @Suppress("UNCHECKED_CAST")
    protected val viewModel by lazyThreadSafetyNone {
        val persistentViewModelClass = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>
        return@lazyThreadSafetyNone ViewModelProvider(this).get(
            persistentViewModelClass
        )
    }
}