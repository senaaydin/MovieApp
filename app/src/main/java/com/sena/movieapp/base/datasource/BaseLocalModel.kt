package com.sena.movieapp.base.datasource

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

open class BaseLocalModel{

    fun toJson(moshi: Moshi): String{
        val jsonAdapter: JsonAdapter<BaseLocalModel> = moshi.adapter(this.javaClass)

        return jsonAdapter.toJson(this)
    }
}