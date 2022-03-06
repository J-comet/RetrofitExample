package hs.project.retrofitexample.retrofit

import android.util.Log
import hs.project.retrofitexample.util.API
import hs.project.retrofitexample.util.isJsonArray
import hs.project.retrofitexample.util.isJsonObject
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/* object 선언 = 싱글턴 */
object RetrofitClient {

    private var retrofitClient: Retrofit? = null

    // retrofit 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d("RetrofitClient", "RetrofitClient getClient() called")

        // okHttp 로깅 인터셉터 추가
        val client = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d(
                "RetrofitClient",
                "log() called / msg = $message"
            )
            when {
                message.isJsonObject() -> {
                    Log.d("RetrofitClient", JSONObject(message).toString(4))
                }

                message.isJsonArray() -> {
                    Log.d("RetrofitClient", JSONObject(message).toString(4))
                }
                else -> {
                    try {
                        Log.d("RetrofitClient", "else" + JSONObject(message).toString(4))
                    } catch (e: Exception) {
                        Log.d("RetrofitClient", "else $message")
                    }
                }
            }
        }

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        // 로깅 인터셉터를 okhttp 클라이언트에 추가
        client.addInterceptor(loggingInterceptor)

        // 기본 파라미터 추가
        val baseParameterInterceptor: Interceptor = (object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                Log.d("RetrofitClient", "intercept() called")
                // origin request
                val originalRequest = chain.request()

                // query 추가
                val addedUrl =
                    originalRequest.url.newBuilder()
                        .addQueryParameter("client_id", API.CLIENT_ID)
                        .build()

                val finalRequest = originalRequest.newBuilder()
                    .url(addedUrl)
                    .method(originalRequest.method, originalRequest.body)
                    .build()

                return chain.proceed(finalRequest)
            }
        })

        // 위에 설정한 기본파라미터를 okhttp 클라이언트에 추가
        client.addInterceptor(baseParameterInterceptor)

        // 연결 시간 설정

        // 10초 동안 연결
        client.connectTimeout(10, TimeUnit.SECONDS)
        client.readTimeout(10, TimeUnit.SECONDS)
        client.writeTimeout(10, TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)  // 실패했을 때 다시 연결할건지


        retrofitClient.let {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
        }

        return retrofitClient
    }
}