package com.example.v2rayadguard.adblock

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader

class AdBlockManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("AdBlockPreferences", Context.MODE_PRIVATE)

    private val TAG = "AdBlockManager"

    fun loadCustomFilters() {
        val filterList = mutableListOf<String>()
        try {
            val inputStream = context.assets.open("custom_filters.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            reader.use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    filterList.add(line!!)
                }
            }
            Log.d(TAG, "Loaded custom filters: $filterList")
        } catch (e: Exception) {
            Log.e(TAG, "Error loading custom filters", e)
        }
    }

    fun isAdBlocked(url: String): Boolean {
        // Implement ad-blocking logic here
        // For now, just return false (not blocked)
        return false
    }

    fun saveUserPreferences(preferences: Map<String, Any>) {
        val editor = sharedPreferences.edit()
        for ((key, value) in preferences) {
            when (value) {
                is String -> editor.putString(key, value)
                is Boolean -> editor.putBoolean(key, value)
                is Int -> editor.putInt(key, value)
                is Float -> editor.putFloat(key, value)
                is Long -> editor.putLong(key, value)
            }
        }
        editor.apply()
    }

    fun getUserPreference(key: String, defaultValue: Any): Any {
        return when (defaultValue) {
            is String -> sharedPreferences.getString(key, defaultValue) ?: defaultValue
            is Boolean -> sharedPreferences.getBoolean(key, defaultValue)
            is Int -> sharedPreferences.getInt(key, defaultValue)
            is Float -> sharedPreferences.getFloat(key, defaultValue)
            is Long -> sharedPreferences.getLong(key, defaultValue)
            else -> defaultValue
        }
    }
}