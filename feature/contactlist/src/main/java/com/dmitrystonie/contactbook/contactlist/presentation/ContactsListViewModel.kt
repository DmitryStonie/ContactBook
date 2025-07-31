package com.dmitrystonie.contactbook.contactlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmitrystonie.contactbook.contactlist.domain.usecase.GetContactsListUseCase
import com.dmitrystonie.contactbook.contactlist.domain.usecase.GetRemoteContactsListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactsListViewModel @Inject constructor(
    private val getContactsListUseCase: GetContactsListUseCase,
    private val getRemoteContactsListUseCase: GetRemoteContactsListUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<ContactsListScreenState>(ContactsListScreenState.Initial)
    val state: LiveData<ContactsListScreenState> = _state

    fun loadContacts() {
        if (_state.value is ContactsListScreenState.Loading || _state.value is ContactsListScreenState.Content) {
            return
        }
        _state.value = ContactsListScreenState.Loading

        viewModelScope.launch {
            try {
                val contacts = getContactsListUseCase()
                _state.value = ContactsListScreenState.Content(contacts = contacts)
            } catch (e: Exception) {
                _state.value = ContactsListScreenState.Error(message = e.message.orEmpty())
            }
        }
    }

    fun loadRemoteContacts() {
        if (_state.value is ContactsListScreenState.Loading) {
            return
        }
        _state.value = ContactsListScreenState.Loading

        viewModelScope.launch {
            try {
                val contacts = getRemoteContactsListUseCase()
                _state.value = ContactsListScreenState.Content(contacts = contacts)
            } catch (e: Exception) {
                _state.value = ContactsListScreenState.Error(message = e.message.orEmpty())
            }
        }
    }

}