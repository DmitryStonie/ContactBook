package com.dmitrystonie.contactbook.contactinfo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dmitrystonie.contactbook.contactinfo.domain.usecase.GetContactUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactViewModel @AssistedInject constructor(
    private val getContactUseCase: GetContactUseCase, @Assisted private val contactId: Long
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(contactId: Long): ContactViewModel
    }

    private val _state = MutableLiveData<ContactScreenState>(ContactScreenState.Initial)
    val state: LiveData<ContactScreenState> = _state

    fun loadContact() {
        if (_state.value is ContactScreenState.Loading || state.value is ContactScreenState.Content) {
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