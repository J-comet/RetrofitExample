package hs.project.retrofitexample.data.user


import com.google.gson.annotations.SerializedName

data class UserData(
    val results: List<Result>?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)