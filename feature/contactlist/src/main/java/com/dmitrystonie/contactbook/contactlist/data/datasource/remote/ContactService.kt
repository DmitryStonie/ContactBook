package com.dmitrystonie.contactbook.contactlist.data.datasource.remote

import com.dmitrystonie.contactbook.contactlist.data.datasource.remote.dto.ContactsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ContactService {
    @GET("/api/")
    suspend fun getContacts(@Query("results") number: Int): ContactsResponse
}