package com.bcci.prfetcher.data.model

import com.google.gson.annotations.SerializedName

data class PRModel(

    val user: PRUser,
    val title:String?,
    @SerializedName("created_at")
    val createdDate:String?,
    @SerializedName("closed_at")
    val closedDate:String?

)


data class PRUser(
    @SerializedName("login")
    val name: String,

    @SerializedName("avatar_url")
    val avatarUrl:String?
)
