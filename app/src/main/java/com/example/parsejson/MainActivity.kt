package com.example.parsejson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var textViewTopDesk: TextView
    lateinit var textViewTitle: TextView
    lateinit var textViewPromoMessage: TextView
    lateinit var textViewBotDesc: TextView
    lateinit var photo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "KotlinApp"
        textViewTopDesk = findViewById(R.id.tvTopDescription)
        textViewPromoMessage = findViewById(R.id.tvPromoMessage)
        textViewTitle = findViewById(R.id.tvTitle)
        textViewBotDesc = findViewById(R.id.tvBottomDesc)
        photo = findViewById(R.id.ivImage)

        val jsonObject = JSONObject()

        jsonObject.put("topDesc", "Data from JSON")
        jsonObject.put("title", "Data from JSON")
        jsonObject.put("promoMessage", "Data from JSON")
        jsonObject.put("botDesc", "Data from JSON")

        photo.load("https://unsplash.com/photos/p5ICJoOSGi4/download?force=true&w=640")

        try {
            val topDesc = jsonObject.getString("topDesc")
            val promoMsg = jsonObject.getString("promoMessage")
            val title = jsonObject.getString("title")
            val bottomDesk = jsonObject.getString("botDesc")

            textViewTopDesk.text = topDesc
            textViewPromoMessage.text = promoMsg
            textViewTitle.text = title
            textViewBotDesc.text = bottomDesk

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}