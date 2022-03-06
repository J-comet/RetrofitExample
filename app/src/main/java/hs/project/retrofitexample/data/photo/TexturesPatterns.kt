package hs.project.retrofitexample.data.photo


import com.google.gson.annotations.SerializedName

data class TexturesPatterns(
    @SerializedName("approved_on")
    val approvedOn: String?,
    val status: String?
)