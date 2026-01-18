package com.example.v2rayadguard.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.v2rayadguard.data.repository.ConfigRepository

class MainViewModel(private val configRepository: ConfigRepository) : ViewModel() {

    private val _isVpnConnected = MutableLiveData<Boolean>()
    val isVpnConnected: LiveData<Boolean> get() = _isVpnConnected

    private val _isAdBlockEnabled = MutableLiveData<Boolean>()
    val isAdBlockEnabled: LiveData<Boolean> get() = _isAdBlockEnabled

    init {
        _isVpnConnected.value = false
        _isAdBlockEnabled.value = false
    }

    fun toggleVpnConnection() {
        _isVpnConnected.value = _isVpnConnected.value != true
        // Logic to connect/disconnect VPN
    }

    fun toggleAdBlock() {
        _isAdBlockEnabled.value = _isAdBlockEnabled.value != true
        // Logic to enable/disable ad-blocking
    }

    fun loadConfiguration() {
        // Load configuration from repository
        configRepository.loadConfig()
    }

    fun saveConfiguration() {
        // Save current configuration to repository
        configRepository.saveConfig()
    }
}