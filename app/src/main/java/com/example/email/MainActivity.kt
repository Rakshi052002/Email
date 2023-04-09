package com.example.email

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var edit_email :EditText
    lateinit var edit_subject: EditText
    lateinit var edit_message: EditText
    lateinit var btnSend: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_email = findViewById(R.id.etEmail)
        edit_subject = findViewById(R.id.etSub)
        edit_message = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btSend)

        btnSend.setOnClickListener {
            var maiId = edit_email.text.toString().trim()
            var sub = edit_subject.text.toString().trim()
            var message = edit_message.text.toString().trim()

            var i = Intent(Intent.ACTION_SEND)

            i.data = Uri.parse("Mail to:")
            i.type= "text/plain"

            i.putExtra(Intent.EXTRA_EMAIL, arrayOf(maiId))
            i.putExtra(Intent.EXTRA_SUBJECT,sub)
            i.putExtra(Intent.EXTRA_TEXT,message)

            startActivity(Intent.createChooser(i,"choose email client"))
        }
    }
}