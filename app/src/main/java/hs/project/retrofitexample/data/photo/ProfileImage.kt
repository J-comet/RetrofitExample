package hs.project.retrofitexample.data.photo


import com.google.gson.annotations.SerializedName

data class ProfileImage(
    val large: String?,
    val medium: String?,
    val small: String?
)