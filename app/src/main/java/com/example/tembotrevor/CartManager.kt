package com.example.tembotrevor

data class CartItem(
    val product: Product,
    var quantity: Int = 1
)

object CartManager {
    private val cartItems = mutableListOf<CartItem>()

    fun addToCart(product: Product, quantity: Int = 1) {
        val existingItem = cartItems.find { it.product.id == product.id }
        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            cartItems.add(CartItem(product, quantity))
        }
    }

    fun removeFromCart(productId: Int) {
        cartItems.removeAll { it.product.id == productId }
    }

    fun updateQuantity(productId: Int, newQuantity: Int) {
        val item = cartItems.find { it.product.id == productId }
        if (item != null) {
            if (newQuantity <= 0) {
                removeFromCart(productId)
            } else {
                item.quantity = newQuantity
            }
        }
    }

    fun getCartItems(): List<CartItem> = cartItems.toList()

    fun getSubtotal(): Double {
        return cartItems.sumOf { it.product.price * it.quantity }
    }

    fun clearCart() {
        cartItems.clear()
    }

    fun getItemCount(): Int = cartItems.sumOf { it.quantity }
}