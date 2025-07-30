package com.dmitrystonie.contactbook.contactinfo.data.datasource

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactdatabase.data.dao.ContactDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.CoordinatesDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.LocationDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.PictureDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.StreetDao
import com.dmitrystonie.contactbook.contactdatabase.data.converter.toContact
import javax.inject.Inject

class ContactDataSource @Inject constructor(
    private val contactDao: ContactDao,
    private val coordinatesDao: CoordinatesDao,
    private val locationDao: LocationDao,
    private val pictureDao: PictureDao,
    private val streetDao: StreetDao
) {
    suspend fun getContact(id: Long): Contact{
        val contactEntity = contactDao.getById(id)
        val pictureEntity = pictureDao.getByContactId(contactEntity.id)
        val coordinatesEntity = coordinatesDao.getByContactId(contactEntity.id)
        val locationEntity = locationDao.getByContactId(contactEntity.id)
        val streetEntity = streetDao.getByContactId(contactEntity.id)
        return contactEntity.toContact(
            locationEntity = locationEntity,
            pictureEntity = pictureEntity,
            streetEntity = streetEntity,
            coordinatesEntity = coordinatesEntity
        )
    }
}