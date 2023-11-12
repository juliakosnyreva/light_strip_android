package ru.lapshina.apprgb
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HttpControler {
    // Создаем функцию для отправки GET запроса и получения ответа в виде строки
    fun sendGetRequest(url: String): String {
        // Создаем экземпляр клиента OkHttp
        val client = OkHttpClient()

        // Создаем запрос с указанным URL
        val request = Request.Builder()
            .url(url)
            .build()

        try {
            // Выполняем запрос и получаем ответ
            val response: Response = client.newCall(request).execute()

            // Получаем тело ответа в виде строки
            return response.body?.string() ?: ""
        } catch (e: IOException) {
            // В случае ошибки выводим ее на консоль и возвращаем пустую строку
            e.printStackTrace()
            return ""
        }
    }

    fun main() {
        // Указываем URL, который вы хотите запросить
        val url = "https://192.168.1.18/action"

        // Вызываем функцию sendGetRequest для отправки запроса и получения ответа
        val response = sendGetRequest(url)

        // Выводим ответ на консоль
        println("Ответ на GET запрос: $response")
    }
}