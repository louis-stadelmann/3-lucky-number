package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SecondActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        val tvLuckyNumber = findViewById<TextView>(R.id.tvLuckyNumber)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val btnShare = findViewById<Button>(R.id.btnSendLuckyNumber)
        val username = intent.getStringExtra("username")
        val randomNumber = generateRandomInt()


        tvLuckyNumber.text = randomNumber.toString()
        tvTitle.text = "${username}, your lucky number is :"

        btnShare.setOnClickListener {
            share(username.toString(), randomNumber)
        }
    }

    fun generateRandomInt(): Int {
        return Random.nextInt(0, 1000)
    }

    fun share(username: String, number: Int) {
        val implicit = Intent(Intent.ACTION_SEND)
        implicit.type = "text/plain"
        // FOR EMAIL
        implicit.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        implicit.putExtra(Intent.EXTRA_EMAIL, arrayOf("test@email.fr"))
        // FOR MESSAGE
        implicit.putExtra("address", "1234567890")
        //FOR BOTH
        implicit.putExtra(Intent.EXTRA_TEXT   , "His lucky number is $number");
        startActivity(implicit);
    }
}