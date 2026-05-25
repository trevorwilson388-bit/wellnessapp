package com.example.tembotrevor

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider

class Meditation : AppCompatActivity() {

    private var timer: CountDownTimer? = null
    private var isRunning = false
    private var timeLeftInMillis = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meditation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val timerDisplay = findViewById<TextView>(R.id.timerDisplay)
        val startButton = findViewById<Button>(R.id.startTimerButton)
        val pauseButton = findViewById<Button>(R.id.pauseTimerButton)
        val resetButton = findViewById<Button>(R.id.resetTimerButton)
        val minuteSlider = findViewById<Slider>(R.id.minuteSlider)
        val sliderLabel = findViewById<TextView>(R.id.sliderLabel)
        val statusText = findViewById<TextView>(R.id.meditationStatusText)

        minuteSlider.addOnChangeListener { _, value, _ ->
            val minutes = value.toInt()
            sliderLabel.text = "$minutes minutes"
            if (!isRunning) {
                timeLeftInMillis = minutes * 60 * 1000L
                updateTimerDisplay(timerDisplay)
            }
        }

        // Set default to 5 minutes
        minuteSlider.value = 5f
        timeLeftInMillis = 5 * 60 * 1000L
        updateTimerDisplay(timerDisplay)

        startButton.setOnClickListener {
            if (!isRunning && timeLeftInMillis > 0) {
                startTimer(timerDisplay, startButton, pauseButton, statusText)
            }
        }

        pauseButton.setOnClickListener {
            if (isRunning) {
                timer?.cancel()
                isRunning = false
                startButton.text = "Resume"
                statusText.text = "Paused. Take a deep breath."
            }
        }

        resetButton.setOnClickListener {
            timer?.cancel()
            isRunning = false
            val minutes = minuteSlider.value.toInt()
            timeLeftInMillis = minutes * 60 * 1000L
            updateTimerDisplay(timerDisplay)
            startButton.text = "Start"
            statusText.text = "Set your meditation duration and begin"
        }
    }

    private fun startTimer(
        timerDisplay: TextView,
        startButton: Button,
        pauseButton: Button,
        statusText: TextView
    ) {
        timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimerDisplay(timerDisplay)
                statusText.text = "Focus on your breath..."
            }

            override fun onFinish() {
                isRunning = false
                timerDisplay.text = "00:00"
                startButton.text = "Start"
                statusText.text = "✨ Meditation complete! Great job! ✨"
            }
        }.start()

        isRunning = true
        startButton.text = "Running"
        statusText.text = "Meditating... Find your calm."
    }

    private fun updateTimerDisplay(timerDisplay: TextView) {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        timerDisplay.text = String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}