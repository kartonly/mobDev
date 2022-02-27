package com.example.lesson1s2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.lesson1s2.data.CurrencyApi
import com.example.lesson1s2.data.CurrencyRepository
import com.example.lesson1s2.ui.main.MainFragment
import com.example.lesson1s2.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor



class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        val model = ViewModelProviders.of(this).get(MainViewModel::class.java).main()
    }

}