package com.example.userregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_page)

        val title: TextView = findViewById(R.id.item_title)
        val text: TextView = findViewById(R.id.item_text)
        val button: Button = findViewById(R.id.button_for_exit)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")

        button.setOnClickListener {
            val intent = Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }
    }
}