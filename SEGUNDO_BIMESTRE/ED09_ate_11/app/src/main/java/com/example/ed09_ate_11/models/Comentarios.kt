package com.example.ed09_ate_11.models

import com.google.gson.annotations.SerializedName

data class Comentarios (
    @SerializedName("comment") var Comentarista: Comentarista? = null,
)

data class Comentarista (
    @SerializedName("id") var id: Int = 0,
    @SerializedName("comment") var comment: String? = null,
)

