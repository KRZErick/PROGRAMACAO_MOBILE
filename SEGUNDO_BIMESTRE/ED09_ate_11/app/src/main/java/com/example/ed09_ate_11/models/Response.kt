package com.example.ed09_ate_11.models

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("meta") val info: Info,
    @SerializedName("items") val resultados: ArrayList<T>
)