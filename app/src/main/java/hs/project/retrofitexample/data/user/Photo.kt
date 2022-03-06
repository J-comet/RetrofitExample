package hs.project.retrofitexample.data.user


import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("blur_hash")
    val blurHash: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    val id: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    val urls: Urls?
)