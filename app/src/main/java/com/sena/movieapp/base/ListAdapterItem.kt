package com.sena.movieapp.base

interface ListAdapterItem {
    val id: Long

    override fun equals(other: Any?): Boolean
}