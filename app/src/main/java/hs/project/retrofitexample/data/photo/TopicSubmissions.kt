package hs.project.retrofitexample.data.photo


import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    val animals: Animals?,
    val health: Health?,
    @SerializedName("textures-patterns")
    val texturesPatterns: TexturesPatterns?
)