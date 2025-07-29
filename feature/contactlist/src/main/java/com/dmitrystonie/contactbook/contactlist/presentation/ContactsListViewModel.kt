package com.dmitrystonie.contactbook.contactlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.dmitrystonie.contactbook.contactlist.domain.usecase.GetContactsListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactsListViewModel @Inject constructor(
    private val getContactsListUseCase: GetContactsListUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<ContactsListScreenState>(ContactsListScreenState.Initial)
    val state: LiveData<ContactsListScreenState> = _state

    fun loadContacts() {
        if (_state.value is ContactsListScreenState.Loading || state.value is ContactsListScreenState.Content) {
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



}