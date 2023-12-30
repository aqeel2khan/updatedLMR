package com.example.batchfinal.retrofilt

import com.example.batchfinal.utils.MyConstant
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    fun getInstance():Retrofit{
        val httpClient = OkHttpClient.Builder().hostnameVerifier { hostname, session -> true }
        httpClient.addInterceptor { chain ->
            val originalRequest = chain.request()
            val request = originalRequest.newBuilder()
            /*    .addHeader("lang", "eg")*/
              //  .addHeader("token", "4oBLf5UVYTkBH9Ks7rn2xQp81iOISfsRafVhhYtdtHBkGp2UIfz7HA==")
                .method(originalRequest.method, originalRequest.body)
                .build()
            chain.proceed(request)
        }
        httpClient.connectTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .build()
        val client = httpClient.build()

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(MyConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
}