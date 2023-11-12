package ru.lapshina.apprgb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.widget.ImageButton
import android.widget.TextView
import com.loopj.android.http.RequestParams
import okhttp3.OkHttpClient
import okhttp3.Request

import java.io.IOException

import android.util.Log

import androidx.appcompat.widget.SwitchCompat


class MainActivity : AppCompatActivity() {

    private lateinit var helloTextView: TextView
    lateinit var http: HttpControler

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Log.e("tag", "!!!!")

        var switchCompat: SwitchCompat = findViewById(R.id.switch_compat)

        switchCompat.setOnCheckedChangeListener{buttonView, isCheked ->

            if (isCheked){
                sendGetRequestWithoutResponseOn("http://192.168.1.18/action/on")
            } else {
                sendGetRequestWithoutResponseOn("http://192.168.1.18/action/off")
            }
        }

        var switchCompatRed: SwitchCompat = findViewById(R.id.switch_compatRed)

        switchCompatRed.setOnCheckedChangeListener{buttonView, isCheked ->

            if (isCheked){
                sendGetRequestWithoutResponseOn("http://192.168.1.18/red/on")
            } else {
                sendGetRequestWithoutResponseOn("http://192.168.1.18/red/off")
            }
        }


        var switchCompatOn: SwitchCompat = findViewById(R.id.switch_compatOn)

        switchCompatOn.setOnCheckedChangeListener{buttonView, isCheked ->

            if (isCheked){
                sendGetRequestWithoutResponseOn("http://192.168.1.18/on/on")
            } else {
                sendGetRequestWithoutResponseOn("http://192.168.1.18/on/off")
            }
        }

        var switchCompatBlue: SwitchCompat = findViewById(R.id.switch_compatBlue)

        switchCompatBlue.setOnCheckedChangeListener{buttonView, isCheked ->

            if (isCheked){
                sendGetRequestWithoutResponseOn("http://192.168.1.18/blue/on")
            } else {
                sendGetRequestWithoutResponseOn("http://192.168.1.18/blue/off")
            }
        }

        var switchCompatGreen: SwitchCompat = findViewById(R.id.switch_compatGreen)

        switchCompatGreen.setOnCheckedChangeListener{buttonView, isCheked ->

            if (isCheked){
                sendGetRequestWithoutResponseOn("http://192.168.1.18/green/on")
            } else {
                sendGetRequestWithoutResponseOn("http://192.168.1.18/green/off")
            }
        }

    }

}

fun sendGetRequestWithoutResponseOn(zapros: String):String {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(zapros) // Замените URL на нужный
        .build()

    // Отправляем GET-запрос, но не ожидаем ответа
    client.newCall(request).enqueue(object : okhttp3.Callback {
        override fun onFailure(call: okhttp3.Call, e: IOException) {
            // Обработка ошибок, если необходимо
            println("Ошибка при отправке запроса: ${e.message}")
        }

        override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
            // Этот блок будет выполнен, если ответ получен,
            // но вы можете оставить его пустым, если не нужно обрабатывать ответ
            // response.body()?.string() содержит тело ответа, но мы его не используем
        }
    })
    return "";
}

fun sendGetRequestWithoutResponseOff() {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("http://192.168.1.18/action/off") // Замените URL на нужный
        .build()

    // Отправляем GET-запрос, но не ожидаем ответа
    client.newCall(request).enqueue(object : okhttp3.Callback {
        override fun onFailure(call: okhttp3.Call, e: IOException) {
            // Обработка ошибок, если необходимо
            println("Ошибка при отправке запроса: ${e.message}")
        }

        override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
            // Этот блок будет выполнен, если ответ получен,
            // но вы можете оставить его пустым, если не нужно обрабатывать ответ
            // response.body()?.string() содержит тело ответа, но мы его не используем
        }
    })
}








