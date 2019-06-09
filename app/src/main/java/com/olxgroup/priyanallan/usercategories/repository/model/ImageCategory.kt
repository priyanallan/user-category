package com.olxgroup.priyanallan.usercategories.repository.model

import com.google.gson.annotations.SerializedName

data class ImageCategory(
    @SerializedName("id")
    val id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("width")
    val width: Long,
    @SerializedName("height")
    val height: Long,
    @SerializedName("url")
    val url: String,
    @SerializedName("download_url")
    val download_url: String
)