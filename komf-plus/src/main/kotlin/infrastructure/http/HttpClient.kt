package infrastructure.http

import java.net.HttpURLConnection
import java.net.URL

class HttpClient {

    fun get(url: String): String {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        return connection.inputStream.bufferedReader().use { it.readText() }
    }

    fun post(url: String, body: String): String {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.doOutput = true
        connection.outputStream.bufferedWriter().use { it.write(body) }
        return connection.inputStream.bufferedReader().use { it.readText() }
    }
}