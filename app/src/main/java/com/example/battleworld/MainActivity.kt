package com.example.yourapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.battleworld.R

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var textViewDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textViewDescription = findViewById(R.id.textViewDescription)

        val tournaments = resources.getStringArray(R.array.tournament_array)
        val descriptions = resources.getStringArray(R.array.tournament_descriptions)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tournaments)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        button.setOnClickListener {
            val selectedPosition = spinner.selectedItemPosition
            textViewDescription.text = descriptions[selectedPosition]
        }
    }
}

