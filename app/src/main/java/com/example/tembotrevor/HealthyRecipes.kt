package com.example.tembotrevor

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HealthyRecipes : AppCompatActivity() {

    private data class Recipe(val name: String, val ingredients: List<String>, val instructions: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_healthy_recipes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recipes = listOf(
            Recipe(
                "Fruit Salad Bowl",
                listOf("1 banana, sliced", "1 apple, diced", "1 orange, segmented", "1/2 cup grapes", "1 tbsp honey", "Mint leaves for garnish"),
                "Mix all fruits in a bowl. Drizzle honey on top. Garnish with mint leaves. Serve fresh."
            ),
            Recipe(
                "Grilled Chicken with Vegetables",
                listOf("200g chicken breast", "1 broccoli head", "1 bell pepper", "1 zucchini", "2 tbsp olive oil", "Salt and pepper to taste"),
                "Season chicken with salt and pepper. Grill for 6-7 mins each side. Steam vegetables. Serve together."
            ),
            Recipe(
                "Vegetable Stir Fry",
                listOf("1 cup broccoli", "1 carrot, julienned", "1 bell pepper", "1 cup mushrooms", "2 tbsp soy sauce", "1 garlic clove, minced"),
                "Heat oil in a pan. Sauté garlic, add vegetables. Stir fry on high heat for 5 mins. Add soy sauce. Serve with rice."
            ),
            Recipe(
                "Oatmeal Breakfast Bowl",
                listOf("1/2 cup rolled oats", "1 cup milk (or almond milk)", "1 banana, sliced", "1 tbsp honey", "1/4 cup berries", "1 tbsp chia seeds"),
                "Cook oats with milk for 5 mins. Top with banana, berries, honey, and chia seeds. Serve warm."
            ),
            Recipe(
                "Avocado Toast",
                listOf("2 slices whole grain bread", "1 ripe avocado", "1/2 lemon (juice)", "Salt and pepper", "Red pepper flakes (optional)", "Cherry tomatoes, halved"),
                "Toast the bread. Mash avocado with lemon juice. Spread on toast. Top with tomatoes, salt, pepper, and red pepper flakes."
            )
        )

        val recipeText = findViewById<TextView>(R.id.recipeText)
        val sb = StringBuilder()

        for ((index, recipe) in recipes.withIndex()) {
            sb.appendLine("${index + 1}. ${recipe.name}")
            sb.appendLine("─" .repeat(30))
            sb.appendLine("📝 Ingredients:")
            for (ingredient in recipe.ingredients) {
                sb.appendLine("  • $ingredient")
            }
            sb.appendLine()
            sb.appendLine("👩‍🍳 Instructions:")
            sb.appendLine("  ${recipe.instructions}")
            sb.appendLine()
            sb.appendLine()
        }

        recipeText.text = sb.toString()
    }
}