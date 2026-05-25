package com.example.tembotrevor

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Daily_Motivation : AppCompatActivity() {

    private val quotes = arrayOf(
        "Believe you can and you're halfway there. - Theodore Roosevelt",
        "The only way to do great work is to love what you do. - Steve Jobs",
        "Your health is an investment, not an expense.",
        "Small daily improvements over time lead to stunning results.",
        "Take care of your body. It's the only place you have to live. - Jim Rohn",
        "The greatest wealth is health. - Virgil",
        "A journey of a thousand miles begins with a single step. - Lao Tzu",
        "Strength does not come from the body. It comes from the will.",
        "Today is a good day for a good day.",
        "Wellness is the complete integration of body, mind, and spirit."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_daily_motivation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val quoteText = findViewById<TextView>(R.id.quoteText)
        val newQuoteButton = findViewById<Button>(R.id.newQuoteButton)

        // Show a random quote on start
        quoteText.text = quotes.random()

        newQuoteButton.setOnClickListener {
            quoteText.text = quotes.random()
        }
    }
}