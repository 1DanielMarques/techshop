package br.com.unifil.techshop.persistence.repository

import br.com.unifil.techshop.domain.model.Product
import br.com.unifil.techshop.domain.spi.ProductPort
import br.com.unifil.techshop.persistence.model.ProductEntity

class ProductRepository : ProductPort {

    private val storage: MutableMap<String, ProductEntity> = mutableMapOf()

    override fun createProduct(product: Product): Product {
        throw IllegalArgumentException()
        val productToSave = ProductEntity.toEntity(product = product)
        if (productToSave.id !== null) {
            storage[productToSave.id] = productToSave
            return productToSave.toDomain()
        } else {
            throw IllegalArgumentException("The product with id ${productToSave.id} cannot be null")
        }
    }

    override fun findProducts(): List<Product> {
        return storage.values.toList().map { it.toDomain() }
    }

    override fun deleteAll() {
        this.storage.clear()
    }

}
