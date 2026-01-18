package com.example.v2rayadguard.doh

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class DohClient(private val baseUrl: String) {

    private val client = OkHttpClient()

    @Throws(IOException::class)
    fun resolve(domain: String): String? {
        val request = Request.Builder()
            .url("$baseUrl/dns-query?name=$domain&type=A")
            .addHeader("Accept", "application/dns-json")
            .build()

        val response: Response = client.newCall(request).execute()
        return handleResponse(response)
    }

    private fun handleResponse(response: Response): String? {
        return if (response.isSuccessful) {
            response.body?.string()
        } else {
            null
        }
    }
}