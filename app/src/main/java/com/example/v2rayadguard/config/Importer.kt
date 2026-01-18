package com.example.v2rayadguard.config

import android.util.Log
import com.example.v2rayadguard.data.repository.ConfigRepository
import com.example.v2rayadguard.util.NetworkUtils
import org.json.JSONObject
import java.io.File

class Importer(private val configRepository: ConfigRepository) {

    fun importConfig(file: File): Boolean {
        return try {
            val jsonString = file.readText()
            val jsonObject = JSONObject(jsonString)

            // Parse the JSON and update the repository
            val vlessConfig = jsonObject.getJSONObject("vless")
            val server = vlessConfig.getString("server")
            val port = vlessConfig.getInt("port")
            val id = vlessConfig.getString("id")
            val alterId = vlessConfig.optInt("alterId", 0)

            configRepository.updateVlessConfig(server, port, id, alterId)

            Log.d(TAG, "Configuration imported successfully from ${file.name}")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to import configuration: ${e.message}")
            false
        }
    }

    companion object {
        private const val TAG = "Importer"
    }
}