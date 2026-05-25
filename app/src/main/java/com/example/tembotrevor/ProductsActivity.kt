package com.example.tembotrevor

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class ProductsActivity : AppCompatActivity() {

    private val products = listOf(
        Product(1, "Yoga Mat Premium", "Non-slip, eco-friendly yoga mat for daily practice", 29.99),
        Product(2, "Vitamin D3 Supplement", "High potency vitamin D3 for immune support, 60 capsules", 15.99),
        Product(3, "Wellness E-Book", "Complete guide to holistic wellness and mindful living", 12.99),
        Product(4, "Meditation Cushion", "Comfortable floor cushion for meditation sessions", 24.99),
        Product(5, "Organic Green Tea", "Premium organic green tea, 100 tea bags", 9.99),
        Product(6, "Resistance Bands Set", "Set of 5 resistance bands for home workouts", 19.99)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val container = findViewById<LinearLayout>(R.id.productsContainer)
        val inflater = LayoutInflater.from(this)

        for (product in products) {
            val productCard = inflater.inflate(R.layout.product_card_item, container, false) as MaterialCardView

            productCard.findViewById<TextView>(R.id.productName).text = product.name
            productCard.findViewById<TextView>(R.id.productDescription).text = product.description
            productCard.findViewById<TextView>(R.id.productPrice).text = "$${String.format("%.2f", product.price)}"

            productCard.findViewById<Button>(R.id.addToCartButton).setOnClickListener {
                CartManager.addToCart(product)
                Toast.makeText(this, "${product.name} added to cart", Toast.LENGTH_SHORT).show()
            }

            container.addView(productCard)
        }
    }
}
