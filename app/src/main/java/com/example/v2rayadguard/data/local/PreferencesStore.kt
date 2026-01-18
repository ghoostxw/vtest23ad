package com.example.v2rayadguard.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PreferencesStore(context: Context) {
    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var isVpnEnabled: Boolean
        get() = sharedPreferences.getBoolean("vpn_enabled", false)
        set(value) = sharedPreferences.edit().putBoolean("vpn_enabled", value).apply()

    var isAdBlockEnabled: Boolean
        get() = sharedPreferences.getBoolean("adblock_enabled", false)
        set(value) = sharedPreferences.edit().putBoolean("adblock_enabled", value).apply()

    var excludedApps: Set<String>
        get() = sharedPreferences.getStringSet("excluded_apps", emptySet()) ?: emptySet()
        set(value) = sharedPreferences.edit().putStringSet("excluded_apps", value).apply()

    var excludedDomains: Set<String>
        get() = sharedPreferences.getStringSet("excluded_domains", emptySet()) ?: emptySet()
        set(value) = sharedPreferences.edit().putStringSet("excluded_domains", value).apply()

    var dnsOverHttpsEnabled: Boolean
        get() = sharedPreferences.getBoolean("dns_over_https_enabled", false)
        set(value) = sharedPreferences.edit().putBoolean("dns_over_https_enabled", value).apply()

    var customFilters: Set<String>
        get() = sharedPreferences.getStringSet("custom_filters", emptySet()) ?: emptySet()
        set(value) = sharedPreferences.edit().putStringSet("custom_filters", value).apply()

    fun clearPreferences() {
        sharedPreferences.edit().clear().apply()
    }
}