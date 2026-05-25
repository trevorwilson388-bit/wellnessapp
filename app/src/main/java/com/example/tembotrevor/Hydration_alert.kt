package com.example.tembotrevor

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hydration_alert : AppCompatActivity() {

    private var waterGlasses = 0
    private val dailyGoal = 8 // Recommended 8 glasses per day

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hydration_alert)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val countText = findViewById<TextView>(R.id.waterCountText)
        val progressBar = findViewById<ProgressBar>(R.id.waterProgressBar)
        val addWaterButton = findViewById<Button>(R.id.addWaterButton)
        val resetButton = findViewById<Button>(R.id.resetWaterButton)
        val statusText = findViewById<TextView>(R.id.waterStatusText)

        progressBar.max = dailyGoal

        fun updateDisplay() {
            countText.text = "$waterGlasses / $dailyGoal glasses"
            progressBar.progress = waterGlasses
            when {
                waterGlasses == 0 -> statusText.text = "Start tracking your water intake!"
                waterGlasses < dailyGoal -> statusText.text = "${dailyGoal - waterGlasses} more glasses to go!"
                waterGlasses == dailyGoal -> statusText.text = "Great! You've met your daily goal!"
                else -> statusText.text = "Amazing! You're over your goal!"
            }
        }

        updateDisplay()

        addWaterButton.setOnClickListener {
            waterGlasses++
            updateDisplay()
        }

        resetButton.setOnClickListener {
            waterGlasses = 0
            updateDisplay()
        }
    }
}