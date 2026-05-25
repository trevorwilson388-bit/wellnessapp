package com.example.tembotrevor

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Start_exercise : AppCompatActivity() {

    private data class Exercise(val name: String, val reps: String, val sets: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_exercise)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val exercises = listOf(
            Exercise("Jumping Jacks", "20 reps", "3 sets"),
            Exercise("Push-ups", "15 reps", "3 sets"),
            Exercise("Squats", "20 reps", "3 sets"),
            Exercise("Plank", "30 seconds", "3 sets"),
            Exercise("Lunges", "12 reps each leg", "3 sets"),
            Exercise("Burpees", "10 reps", "3 sets"),
            Exercise("Bicycle Crunches", "20 reps", "3 sets"),
            Exercise("Dumbbell Rows", "12 reps", "3 sets"),
            Exercise("Mountain Climbers", "30 seconds", "3 sets"),
            Exercise("Cool Down Stretches", "5 minutes", "1 set")
        )

        val exerciseListText = findViewById<TextView>(R.id.exerciseListText)
        val sb = StringBuilder()
        sb.appendLine("🏋️ Quick Workout Routine")
        sb.appendLine("=".repeat(40))
        sb.appendLine()

        for ((index, exercise) in exercises.withIndex()) {
            sb.appendLine("${index + 1}. ${exercise.name}")
            sb.appendLine("   Reps: ${exercise.reps}")
            sb.appendLine("   Sets: ${exercise.sets}")
            sb.appendLine()
        }

        sb.appendLine("=".repeat(40))
        sb.appendLine("💪 Stay consistent! Track your progress daily.")

        exerciseListText.text = sb.toString()
    }
}