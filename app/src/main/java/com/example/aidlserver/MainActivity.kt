package com.example.aidlserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * server端的aidl,必须包名和client端的一致,否则报错:java.lang.NullPointerException
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}