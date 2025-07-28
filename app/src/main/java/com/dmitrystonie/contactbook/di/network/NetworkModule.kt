package com.dmitrystonie.contactbook.di.network

import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return Json.Default.asConverterFactory(
            "application/json; charset=UTF8".toMediaType())
    }

    @Provides
    fun providesBaseUrl(): String = "base url"

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory( converterFactory)
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)
        return clientBuilder.build()
    }

}