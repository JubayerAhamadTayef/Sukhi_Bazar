package com.jubayer_ahamad_tayef.data.model // Package declaration for data models

import kotlinx.serialization.Serializable // Importing the Kotlin Serialization library

@Serializable // Annotation to mark the class as serializable by Kotlin Serialization
class DataProductModel(
    val id: Long,
    val title: String,
    val price: Double,
    val category: String,
    val description: String,
    val image: String
) {
    // Converts the DataProductModel to the domain model Product
    fun toProduct() = com.jubayer_ahamad_tayef.domain.model.Product(
        id = id,
        title = title,
        price = price,
        category = category,
        description = description,
        image = image
    )
}