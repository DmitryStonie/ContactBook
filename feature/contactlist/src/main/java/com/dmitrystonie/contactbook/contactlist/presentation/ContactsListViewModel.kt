package com.dmitrystonie.contactbook.contactlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dmitrystonie.contactbook.contactlist.domain.usecase.GetContactsListUseCase
import com.dmitrystonie.contactbook.contactlist.domain.usecase.GetRemoteContactsListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactsListViewModel @Inject constructor(
    private val getContactsListUseCase: GetContactsListUseCase,
    private val getRemoteContactsListUseCase: GetRemoteContactsListUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<ContactsListScreenState>(ContactsListScreenState.Initial)
    val state: LiveData<ContactsListScreenState> = _state

    private val _isRefreshing = MutableStateFlow(_state.value == ContactsListScreenState.Loading)
    val isRefreshing = _isRefreshing.asStateFlow()

    fun loadContacts() {
        Log.d("INFO-LIST", "loading contacts in viewmodel")
        if (_state.value is ContactsListScreenState.Loading) {
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

    fun loadRemoteContacts(){
        Log.d("INFO-LIST", "loading contacts remote in viewmodel")
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