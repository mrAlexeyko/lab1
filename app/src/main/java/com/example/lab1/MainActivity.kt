package com.example.lab1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerLanguages: Spinner
    private lateinit var buttonOk: Button
    private lateinit var buttonCancel: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerLanguages = findViewById(R.id.spinnerLanguages)
        buttonOk = findViewById(R.id.buttonOk)
        buttonCancel = findViewById(R.id.buttonCancel)
        textViewResult = findViewById(R.id.textViewResult)

        val languages = resources.getStringArray(R.array.programming_languages)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLanguages.adapter = adapter

        buttonOk.setOnClickListener {
            if (spinnerLanguages.selectedItemPosition == 0) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Помилка")
                builder.setMessage("Завершіть введення всіх даних")
                builder.setPositiveButton("OK", null)
                builder.show()
            } else {
                val selectedLanguage = spinnerLanguages.selectedItem.toString()
                textViewResult.text = "Обрана мова: $selectedLanguage"
            }
        }

        buttonCancel.setOnClickListener {
            textViewResult.text = ""
            spinnerLanguages.setSelection(0)
        }
    }
}
