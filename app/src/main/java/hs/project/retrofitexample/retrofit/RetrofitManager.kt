package hs.project.retrofitexample.retrofit

import android.util.Log
import com.google.gson.JsonElement
import hs.project.retrofitexample.data.photo.PhotoData
import hs.project.retrofitexample.util.API
import hs.project.retrofitexample.util.RESPONSE_STATE
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    // Retrofit 인터페이스 가져옴
    private val callRetrofitInterface: RetrofitInterface? =
        RetrofitClient.getClient(API.BASE_URL)?.create(RetrofitInterface::class.java)

    // 사진 검색 API 호출
    //  completion: (넘겨줄 데이터 형)
    fun searchPhotos(searchTerm: String?, completion: (RESPONSE_STATE, PhotoData?) -> Unit) {

        // null 이면 빈값, null 이 아니면 searchTerm 을 넣음
        val strSearchTerm = searchTerm ?: ""

        // null 이면 return
        val call = callRetrofitInterface?.searchPhotos(searchTerm = strSearchTerm) ?: return

        call.enqueue(object : retrofit2.Callback<PhotoData> {
            override fun onResponse(call: Call<PhotoData>, response: Response<PhotoData>) {
                Log.d("RetrofitManager", "searchPhotos onResponse() called, response: ${response.body().toString()}")
                response.body()?.let { completion(RESPONSE_STATE.SUCCESS, it) }
            }

            override fun onFailure(call: Call<PhotoData>, t: Throwable) {
                Log.d("RetrofitManager", "searchPhotos onFailure() called, t: $t")
                completion(RESPONSE_STATE.FAIL, null)
            }
        })
    }

    // 유저 검색 API 호출
    fun searchUsers(searchTerm: String?, completion: (RESPONSE_STATE, String) -> Unit) {

        // null 이면 빈값, null 이 아니면 searchTerm 을 넣음
        val strSearchTerm = searchTerm ?: ""

        // null 이면 return
        val call = callRetrofitInterface?.searchUsers(searchTerm = strSearchTerm) ?: return

        call.enqueue(object : retrofit2.Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d("RetrofitManager", "searchUsers onResponse() called, response: ${response.body().toString()}")
                completion(RESPONSE_STATE.SUCCESS, response.body().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d("RetrofitManager", "searchUsers onFailure() called, t: $t")
                completion(RESPONSE_STATE.FAIL, t.toString())
            }
        })
    }
}