package hs.project.retrofitexample.data.user


import com.google.gson.annotations.SerializedName

data class Links(
    val followers: String?,
    val following: String?,
    val html: String?,
    val likes: String?,
    val photos: String?,
    val portfolio: String?,
    val self: String?
)