package hs.project.retrofitexample

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import hs.project.retrofitexample.adapter.ImageAdapter
import hs.project.retrofitexample.data.photo.PhotoData
import hs.project.retrofitexample.data.photo.Result
import hs.project.retrofitexample.data.photo.Urls
import hs.project.retrofitexample.data.photo.UrlsX
import hs.project.retrofitexample.databinding.ActivityImageSearchBinding
import hs.project.retrofitexample.retrofit.RetrofitManager
import hs.project.retrofitexample.util.RESPONSE_STATE

class ImageSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageSearchBinding
    private lateinit var imgList: ArrayList<UrlsX>
    private lateinit var resultList: ArrayList<Result>
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageAdapter = ImageAdapter(this)

        binding.rvImg.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(this@ImageSearchActivity)
        }

        binding.btnSearchImg.setOnClickListener {

            imgList = arrayListOf()

            RetrofitManager.instance.searchPhotos(
                searchTerm = binding.etSearch.text.toString(),
                completion = { state, resultPhotoData ->
                    when (state) {
                        RESPONSE_STATE.SUCCESS -> {
//                        binding.tvResult.text = responseBody
                            Log.d("RetrofitManager", "API 호출 성공")
                            val photoData: PhotoData? = resultPhotoData

                            photoData.let {
                                resultList = photoData?.results as ArrayList<Result>

                                for (item in resultList) {
                                    item.urls?.let { urlsX -> imgList.add(urlsX) }
                                }
                                imageAdapter.setData(imgList)
                            }

                        }
                        RESPONSE_STATE.FAIL -> {
                            Toast.makeText(this, "API 호출 에러", Toast.LENGTH_SHORT).show()
                            Log.d("RetrofitManager", "API 호출 에러")
                        }
                    }
                }
            )

            // 이미지검색 API 호출
//            RetrofitManager.instance.searchPhotos(
//                searchTerm = binding.etSearch.text.toString(),
//                completion = { responseState: RESPONSE_STATE, response: PhotoData ->
//                    when (responseState) {
//                        RESPONSE_STATE.SUCCESS -> {
////                        binding.tvResult.text = responseBody
//                            Log.d("RetrofitManager", "API 호출 성공")
//                            val photoData: PhotoData = response.body
//                            imgList.add(responseBody)
//
//                        }
//                        RESPONSE_STATE.FAIL -> {
//                            Toast.makeText(this, "API 호출 에러", Toast.LENGTH_SHORT).show()
//                            Log.d("RetrofitManager", "API 호출 에러")
//                        }
//                    }
//                })
        }


    }
}