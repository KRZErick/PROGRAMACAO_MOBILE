package com.example.ed09_ate_11.models

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("total_count") var count: Int,
    @SerializedName("current_page") var pages: Int,
    @SerializedName("next_page") var next: String?,
    @SerializedName("previous_page") var prev: String?,
)