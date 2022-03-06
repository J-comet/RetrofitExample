package hs.project.retrofitexample.data.photo


import com.google.gson.annotations.SerializedName

data class PhotoData(
    val results: List<Result>?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)