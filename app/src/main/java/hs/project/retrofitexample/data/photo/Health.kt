package hs.project.retrofitexample.data.photo


import com.google.gson.annotations.SerializedName

data class Health(
    @SerializedName("approved_on")
    val approvedOn: String?,
    val status: String?
)