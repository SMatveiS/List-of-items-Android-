package com.example.userregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val userEmail: EditText = findViewById(R.id.user_email)
        val userLogin: EditText = findViewById(R.id.user_login)
        val userPassword: EditText = findViewById(R.id.user_password)
        val button: Button = findViewById(R.id.button)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }
        
        button.setOnClickListener() {
            val email = userEmail.text.toString().trim()
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (email == "" || login == "" || password == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            else {
                val user = User(email, login, password)

                val db = DBHelper(this, null)
                db.addUser(user)

                Toast.makeText(this, "Вы зарегестрировались", Toast.LENGTH_LONG).show()

                userEmail.text.clear()
                userLogin.text.clear()
                userPassword.text.clear()

                val intent = Intent(this, AuthorizationActivity::class.java)
                startActivity(intent)
            }
        }
    }
}