package br.com.unifil.techshop.api.usecase

import br.com.unifil.techshop.domain.api.FindProduct
import br.com.unifil.techshop.domain.api.usecase.FindProductUseCase
import br.com.unifil.techshop.domain.model.Product
import br.com.unifil.techshop.domain.spi.ProductPort
import br.com.unifil.techshop.persistence.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FindProductUseCaseTest {

    private val productPort: ProductPort = ProductRepository()
    private val findProduct: FindProduct = FindProductUseCase(productPort = productPort)

    @BeforeEach
    fun setup() {
        productPort.deleteAll()
    }

    @Test
    fun `should find all products`() {
        //given
        val productsToCreate = listOf(
            Product(
                name = "p1",
                price = 10.0
            ),
            Product(
                name = "p2",
                price = 20.0
            )
        )
        productsToCreate.forEach { this.productPort.createProduct(product = it) }
        //when
        val response = this.findProduct.findProducts()
        //then
        assertEquals(2, response.size)
        assertEquals("p1", response.first().name)
        assertEquals(10.0, response.first().price)
        assertEquals("p2", response.last().name)
        assertEquals(20.0, response.last().price)

    }

}
