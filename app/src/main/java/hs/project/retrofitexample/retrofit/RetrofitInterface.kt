package hs.project.retrofitexample.retrofit

import com.google.gson.JsonElement
import hs.project.retrofitexample.data.photo.PhotoData
import hs.project.retrofitexample.util.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    // https://api.unsplash.com/search/photos?query="searchTerm"
    @GET(API.SEARCH_PHOTO)
    fun searchPhotos(@Query("query") searchTerm: String) : Call<PhotoData>

    // https://api.unsplash.com/search/users?query="searchTerm"
    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") searchTerm: String) : Call<JsonElement>

}