package com.dmitrystonie.contactbook.contactlist.data.datasource

import com.dmitrystonie.contactbook.contactlist.data.datasource.dto.ContactsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


interface ContactService {
    @GET("/api/")
    suspend fun getContacts(@Query("results") number: Int): ContactsResponse
}