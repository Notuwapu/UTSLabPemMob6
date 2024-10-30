package com.example.utslab

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        // Inisialisasi komponen UI
        val previewName = findViewById<TextView>(R.id.previewName)
        val previewDate = findViewById<TextView>(R.id.previewDate)
        val previewMessage = findViewById<TextView>(R.id.previewMessage)
        val previewBorder = findViewById<ImageView>(R.id.previewBorder)
        val backButton = findViewById<ImageButton>(R.id.backButton)

        // Mendapatkan data dari intent
        val name = intent.getStringExtra("name")
        val date = intent.getStringExtra("date")
        val message = intent.getStringExtra("message")
        val border = intent.getIntExtra("border", R.drawable.border1)

        // Menampilkan data di UI
        previewName.text = name
        previewDate.text = date
        previewMessage.text = message
        previewBorder.setImageResource(border)

        // untuk tombol kembali
        backButton.setOnClickListener {
            finish()
        }
    }
}