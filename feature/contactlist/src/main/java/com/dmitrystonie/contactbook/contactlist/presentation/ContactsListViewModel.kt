package com.dmitrystonie.contactbook.contactlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.viewModelScope
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
        Log.d("INFO", "Change state to Loading in loadContacts")
        _state.value = ContactsListScreenState.Loading

        viewModelScope.launch {
            try {
                val contacts = getContactsListUseCase()
                Log.d("INFO", "$contacts")
                _state.value = ContactsListScreenState.Content(contacts = contacts)
                Log.d("INFO", "new state ${state.value}")
            } catch (e: Exception) {
                _state.value = ContactsListScreenState.Error(message = e.message.orEmpty())
            }
        }
    }



}