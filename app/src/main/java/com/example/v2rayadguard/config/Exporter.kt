package com.example.v2rayadguard.config

import com.example.v2rayadguard.data.repository.ConfigRepository
import com.example.v2rayadguard.util.NetworkStats
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Exporter(private val configRepository: ConfigRepository) {

    fun exportVlessConfig(): String {
        val config = configRepository.getVlessConfig()
        return Json.encodeToString(config)
    }

    fun exportAdBlockConfig(): String {
        val filters = configRepository.getAdBlockFilters()
        return Json.encodeToString(filters)
    }

    fun exportAllConfigs(): Map<String, String> {
        return mapOf(
            "vless" to exportVlessConfig(),
            "adblock" to exportAdBlockConfig()
        )
    }
}