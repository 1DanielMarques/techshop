package br.com.unifil.techshop.domain.spi

import br.com.unifil.techshop.domain.model.Product

interface ProductPort {

    fun createProduct(product: Product) : Product

    fun findProducts(): List<Product>

    fun deleteAll()

}
