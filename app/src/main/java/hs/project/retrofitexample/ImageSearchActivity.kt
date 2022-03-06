package hs.project.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import hs.project.retrofitexample.databinding.ActivityImageSearchBinding
import hs.project.retrofitexample.retrofit.RetrofitManager
import hs.project.retrofitexample.util.RESPONSE_STATE

class ImageSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearchImg.setOnClickListener {

            // 이미지검색 API 호출
            RetrofitManager.instance.searchPhotos(searchTerm = binding.etSearch.text.toString(), completion = {
                responseState: RESPONSE_STATE, responseBody: String ->
                when(responseState) {
                    RESPONSE_STATE.SUCCESS -> {
                        binding.tvResult.text = responseBody
                        Log.d("RetrofitManager", "API 호출 성공")
                    }
                    RESPONSE_STATE.FAIL -> {
                        Toast.makeText(this,"API 호출 에러", Toast.LENGTH_SHORT).show()
                        Log.d("RetrofitManager", "API 호출 에러")
                    }
                }
            })
        }



    }
}