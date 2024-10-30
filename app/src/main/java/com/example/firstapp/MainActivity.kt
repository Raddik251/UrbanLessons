package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var textResult: TextView
    private lateinit var textCount: TextView
    private lateinit var buttonOne: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inputText = findViewById(R.id.input_textArea)
        textResult = findViewById(R.id.text_result)
        textCount = findViewById(R.id.text_count)
        buttonOne = findViewById(R.id.button_one)

        if (buttonOne.isActivated) {
            onButtonClick(buttonOne)
        }
    }

    fun onButtonClick(view: View) {
        val text = inputText.text
        textResult.text = text.reversed()
        textCount.text = "${text.count()}"
    }
}