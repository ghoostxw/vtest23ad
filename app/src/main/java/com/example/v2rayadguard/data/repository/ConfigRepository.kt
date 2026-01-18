package com.example.v2rayadguard.data.repository

import com.example.v2rayadguard.data.local.PreferencesStore
import com.example.v2rayadguard.config.Importer
import com.example.v2rayadguard.config.Exporter

class ConfigRepository(
    private val preferencesStore: PreferencesStore,
    private val importer: Importer,
    private val exporter: Exporter
) {
    fun getConfiguration(): String {
        // Logic to retrieve the current configuration
        return preferencesStore.getConfiguration()
    }

    fun saveConfiguration(config: String) {
        // Logic to save the configuration
        preferencesStore.saveConfiguration(config)
    }

    fun importConfiguration(filePath: String) {
        // Logic to import configuration from a file
        val config = importer.importFromFile(filePath)
        saveConfiguration(config)
    }

    fun exportConfiguration(filePath: String) {
        // Logic to export the current configuration to a file
        val config = getConfiguration()
        exporter.exportToFile(config, filePath)
    }
}