package com.jetbrains.jonnyzzz.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import org.kotlin.mpp.mobile.getGuangZhouWeather
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

  lateinit var handler: Handler;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    handler = Handler()
    setContentView(R.layout.activity_main)


    thread {
      val guangZhouWeather = getGuangZhouWeather()
      handler.post { findViewById<TextView>(R.id.main_text).text = guangZhouWeather.data.wendu }
    }

  }
}
