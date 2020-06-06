package com.example.abridge.view

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.HORIZONTAL
        val textView = TextView(this)
        textView.text = "Hello"
        linearLayout.addView(textView)
        textView.text = "World"
        linearLayout.addView(textView)
        setContentView(linearLayout)
        
    }


}