package com.example.gdgsampleapp.model

sealed class ViewState {

    object Loading : ViewState()
    object Complete : ViewState()
    class Error(val message: String?) : ViewState()
}
