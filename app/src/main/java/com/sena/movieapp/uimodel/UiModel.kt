package com.sena.movieapp.uimodel

import com.sena.movieapp.base.ListAdapterItem
import java.io.Serializable

interface GenreUiModel : ListAdapterItem, Serializable {

    override val id: Long

    val name: String
}