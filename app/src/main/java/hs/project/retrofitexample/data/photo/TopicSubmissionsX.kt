package hs.project.retrofitexample.data.photo


import com.google.gson.annotations.SerializedName

data class TopicSubmissionsX(
    val animals: AnimalsX?,
    val fashion: Fashion?,
    val film: Film?,
    val nature: Nature?,
    val wallpapers: Wallpapers?
)