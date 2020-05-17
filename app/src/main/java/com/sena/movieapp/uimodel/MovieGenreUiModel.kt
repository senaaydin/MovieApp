package com.sena.movieapp.uimodel

import com.sena.movieapp.base.ListAdapterItem

data class MovieGenreUiModel(
    override val id: Long,
    override val name: String
) : GenreUiModel, ListAdapterItem