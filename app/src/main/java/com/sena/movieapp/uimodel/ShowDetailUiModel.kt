package com.sena.movieapp.uimodel

import android.content.Context
import com.sena.movieapp.R

interface ShowDetailUiModel : ShowUiModel {
    val runtime: Int?

    fun runtime(context: Context): String {
        return runtime?.let { runtime ->
            context.getString(R.string.show_detail_message_min_formatted, runtime)
        } ?: context.getString(R.string.show_detail_message_not_specified)
    }
}