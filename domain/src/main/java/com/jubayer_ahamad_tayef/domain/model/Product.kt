package com.jubayer_ahamad_tayef.domain.model // Package for domain models

// Data class representing a Product in the domain layer
data class Product(
    val id: Long,            // Unique identifier for the product
    val title: String,       // Name of the product
    val price: Double,       // Price of the product
    val category: String,    // Category to which the product belongs
    val description: String, // Description of the product
    val image: String        // URL or path to the product's image
) {
    // Computed property to get the price as a formatted string
    val priceString: String
        get() = "$$price"
}