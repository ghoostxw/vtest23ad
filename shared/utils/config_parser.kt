package com.example.v2rayadguard.utils

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.File

data class VlessConfig(
    val version: String,
    val services: List<Service>
)

data class Service(
    val name: String,
    val type: String,
    val address: String,
    val port: Int,
    val uuid: String,
    val alterId: Int? = null,
    val security: String? = null,
    val network: String? = null,
    val tlsSettings: TlsSettings? = null
)

data class TlsSettings(
    val serverName: String? = null,
    val allowInsecure: Boolean = false
)

object ConfigParser {
    private val gson = Gson()

    fun parseVlessConfig(file: File): VlessConfig? {
        return try {
            val json = file.readText()
            gson.fromJson(json, VlessConfig::class.java)
        } catch (e: JsonSyntaxException) {
            null
        } catch (e: Exception) {
            null
        }
    }

    fun exportVlessConfig(config: VlessConfig, file: File) {
        val json = gson.toJson(config)
        file.writeText(json)
    }
}