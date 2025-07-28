package com.dmitrystonie.contactbook.contactlist.data.datasource

import com.dmitrystonie.contactbook.contactlist.data.datasource.dto.ContactsResponse
import retrofit2.http.GET


interface ContactService {
    @GET("/api/")
    suspend fun getContacts(): ContactsResponse
}