package com.example.tembotrevor

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        displayCart()
    }

    override fun onResume() {
        super.onResume()
        displayCart()
    }

    private fun displayCart() {
        val container = findViewById<LinearLayout>(R.id.cartItemsContainer)
        val emptyMessage = findViewById<TextView>(R.id.cartEmptyMessage)
        val subtotalText = findViewById<TextView>(R.id.subtotalText)
        val checkoutButton = findViewById<Button>(R.id.checkoutButton)

        container.removeAllViews()
        val cartItems = CartManager.getCartItems()

        if (cartItems.isEmpty()) {
            emptyMessage.visibility = android.view.View.VISIBLE
            checkoutButton.visibility = android.view.View.GONE
            subtotalText.text = "Subtotal: $0.00"
            return
        }

        emptyMessage.visibility = android.view.View.GONE
        checkoutButton.visibility = android.view.View.VISIBLE

        val inflater = LayoutInflater.from(this)

        for (cartItem in cartItems) {
            val itemCard = inflater.inflate(R.layout.cart_item_card, container, false) as MaterialCardView

            itemCard.findViewById<TextView>(R.id.cartItemName).text = cartItem.product.name
            itemCard.findViewById<TextView>(R.id.cartItemPrice).text =
                "$${String.format("%.2f", cartItem.product.price)} each"
            itemCard.findViewById<TextView>(R.id.cartItemQuantity).text = cartItem.quantity.toString()

            itemCard.findViewById<Button>(R.id.decreaseQuantityButton).setOnClickListener {
                CartManager.updateQuantity(cartItem.product.id, cartItem.quantity - 1)
                displayCart()
            }

            itemCard.findViewById<Button>(R.id.increaseQuantityButton).setOnClickListener {
                CartManager.updateQuantity(cartItem.product.id, cartItem.quantity + 1)
                displayCart()
            }

            container.addView(itemCard)
        }

        subtotalText.text = "Subtotal: $${String.format("%.2f", CartManager.getSubtotal())}"

        checkoutButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Checkout")
                .setMessage("Total amount: $${String.format("%.2f", CartManager.getSubtotal())}\n\nThank you for your purchase! This is a demo checkout.")
                .setPositiveButton("OK") { _, _ ->
                    CartManager.clearCart()
                    Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_LONG).show()
                    displayCart()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }
}
