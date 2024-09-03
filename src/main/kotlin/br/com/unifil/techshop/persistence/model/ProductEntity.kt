package br.com.unifil.techshop.persistence.model

import br.com.unifil.techshop.domain.model.Product
import java.util.*

data class ProductEntity(
    val id: String? = null,
    val name: String,
    val price: Double
) {

    companion object {
        fun toEntity(product: Product): ProductEntity {
            return ProductEntity(
                id = product.id ?: UUID.randomUUID().toString(),
                name = product.name,
                price = product.price
            )
        }
    }

    fun toDomain(): Product {
        return Product(
            id = this.id,
            name = this.name,
            price = this.price
        )
    }

}
