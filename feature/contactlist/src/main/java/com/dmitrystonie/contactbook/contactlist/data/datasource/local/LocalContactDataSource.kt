package com.dmitrystonie.contactbook.contactlist.data.datasource.local

import com.dmitrystonie.contactbook.contact.domain.Contact
import com.dmitrystonie.contactbook.contactdatabase.data.dao.ContactDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.CoordinatesDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.LocationDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.PictureDao
import com.dmitrystonie.contactbook.contactdatabase.data.dao.StreetDao
import com.dmitrystonie.contactbook.contactdatabase.data.converter.toContact
import com.dmitrystonie.contactbook.contactdatabase.data.converter.toContactEntity
import com.dmitrystonie.contactbook.contactdatabase.data.converter.toCoordinatesEntity
import com.dmitrystonie.contactbook.contactdatabase.data.converter.toLocationEntity
import com.dmitrystonie.contactbook.contactdatabase.data.converter.toPictureEntity
import com.dmitrystonie.contactbook.contactdatabase.data.converter.toStreetEntity
import javax.inject.Inject

class LocalContactDataSource @Inject constructor(
    private val contactDao: ContactDao,
    private val coordinatesDao: CoordinatesDao,
    private val locationDao: LocationDao,
    private val pictureDao: PictureDao,
    private val streetDao: StreetDao
) {
    suspend fun saveContacts(contacts: List<Contact>) {
        contacts.forEach { contact ->
            val id = contactDao.insert(contact.toContactEntity())
            coordinatesDao.insert(contact.location.coordinates.toCoordinatesEntity(id))
            locationDao.insert(contact.location.toLocationEntity(id))
            pictureDao.insert(contact.picture.toPictureEntity(id))
            streetDao.insert(contact.location.street.toStreetEntity(id))
        }
    }
    suspend fun getContacts(): List<Contact>{
        val contactEntities = contactDao.getAll()
        return contactEntities.map{ contactEntity ->
            val pictureEntity = pictureDao.getByContactId(contactEntity.id)
            val coordinatesEntity = coordinatesDao.getByContactId(contactEntity.id)
            val locationEntity = locationDao.getByContactId(contactEntity.id)
            val streetEntity = streetDao.getByContactId(contactEntity.id)
            contactEntity.toContact(
                locationEntity = locationEntity,
                pictureEntity = pictureEntity,
                streetEntity = streetEntity,
                coordinatesEntity = coordinatesEntity
            )
        }
    }
    suspend fun deleteContacts(){
        val contactEntities = contactDao.getAll()
        contactEntities.forEach { contactEntity -> contactDao.delete(contactEntity) }
    }
}