package com.example.tembotrevor

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Nutrition : AppCompatActivity() {

    private data class NutritionCategory(val title: String, val tips: List<String>)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nutrition)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val categories = listOf(
            NutritionCategory(
                "🥗 Balanced Diet",
                listOf(
                    "Include all food groups: proteins, carbs, fats, vitamins, and minerals",
                    "Follow the plate method: 1/2 veggies, 1/4 protein, 1/4 grains",
                    "Eat a rainbow of colorful fruits and vegetables daily"
                )
            ),
            NutritionCategory(
                "💧 Hydration",
                listOf(
                    "Drink at least 8 glasses (2 liters) of water daily",
                    "Start your morning with a glass of warm water with lemon",
                    "Herbal teas and infused water count toward hydration"
                )
            ),
            NutritionCategory(
                "🌾 Whole Grains",
                listOf(
                    "Choose brown rice, quinoa, and oats over refined grains",
                    "Whole grains provide fiber that aids digestion",
                    "Look for '100% whole grain' on labels"
                )
            ),
            NutritionCategory(
                "🥩 Protein Power",
                listOf(
                    "Include lean proteins like chicken, fish, tofu, and legumes",
                    "Plant-based proteins (beans, lentils) are great for heart health",
                    "Spread protein intake throughout the day for best absorption"
                )
            ),
            NutritionCategory(
                "🍎 Vitamins & Minerals",
                listOf(
                    "Vitamin C from citrus fruits boosts immunity",
                    "Calcium from dairy or fortified plant milk supports bones",
                    "Iron from leafy greens and beans prevents fatigue"
                )
            ),
            NutritionCategory(
                "🚫 Limit These",
                listOf(
                    "Reduce added sugar - check labels for hidden sugars",
                    "Limit processed foods and trans fats",
                    "Watch sodium intake - aim for less than 2300mg daily"
                )
            )
        )

        val nutritionText = findViewById<TextView>(R.id.nutritionText)
        val sb = StringBuilder()

        sb.appendLine("🥦 Nutrition Tips & Advice")
        sb.appendLine("=".repeat(35))
        sb.appendLine()

        for (category in categories) {
            sb.appendLine(category.title)
            sb.appendLine("─".repeat(25))
            for (tip in category.tips) {
                sb.appendLine("  • $tip")
            }
            sb.appendLine()
        }

        sb.appendLine("=".repeat(35))
        sb.appendLine("🌟 Small changes lead to big health improvements!")

        nutritionText.text = sb.toString()
    }
}