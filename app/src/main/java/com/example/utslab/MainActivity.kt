package com.example.utslab

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextMessage: EditText
    private lateinit var editTextDate: EditText
    private var selectedBorder = R.drawable.border1 // Default border

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextMessage = findViewById(R.id.editTextMessage)
        editTextDate = findViewById(R.id.editTextDate)

        // Set up the DatePickerDialog for the date EditText
        editTextDate.setOnClickListener {
            showDatePickerDialog()
        }

        // Set border selection logic
        val border1 = findViewById<ImageView>(R.id.border1)
        val border2 = findViewById<ImageView>(R.id.border2)

        border1.setOnClickListener { selectedBorder = R.drawable.border1 }
        border2.setOnClickListener { selectedBorder = R.drawable.border2 }

        val btnPreview = findViewById<Button>(R.id.btnPreview)
        btnPreview.setOnClickListener {
            val name = editTextName.text.toString()
            val message = editTextMessage.text.toString()
            val date = editTextDate.text.toString()

            // Start PreviewActivity and pass the data
            val intent = Intent(this, PreviewActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("message", message)
            intent.putExtra("date", date)
            intent.putExtra("border", selectedBorder)
            startActivity(intent)
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                // Format date as MM/DD/YYYY
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)
                val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
                editTextDate.setText(dateFormat.format(selectedDate.time))
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}
