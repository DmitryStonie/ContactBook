package com.dmitrystonie.contactbook.contactinfo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmitrystonie.contactbook.contactinfo.domain.usecase.GetContactUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactViewModel @Inject constructor(
    private val getContactUseCase: GetContactUseCase
) : ViewModel() {
    private val _state = MutableLiveData<ContactScreenState>(ContactScreenState.Initial)
    val state: LiveData<ContactScreenState> = _state

    fun loadContact(contactId: Long) {
        if (_state.value is ContactScreenState.Loading) {
            return
        }
        _state.value = ContactScreenState.Loading
        viewModelScope.launch {
            try {
                val contact = getContactUseCase(contactId)
                _state.value = ContactScreenState.Content(contact = contact)
            } catch (e: Exception) {
                _state.value = ContactScreenState.Error(message = e.message.orEmpty())
            }
        }
    }
}