package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGetNumber = findViewById<Button>(R.id.btnGetLucky)
        val etName = findViewById<EditText>(R.id.etName)

        btnGetNumber.setOnClickListener {
            if (TextUtils.isEmpty(etName.text)) {
                etName.error = "Enter your name !"
            } else {
                val username = etName.text.toString()
                val intent = Intent(this, SecondActivity::class.java)

                intent.putExtra("username", username)
                startActivity(intent)
            }
        }
    }
}