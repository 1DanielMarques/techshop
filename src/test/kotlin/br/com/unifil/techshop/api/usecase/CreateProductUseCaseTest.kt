package br.com.unifil.techshop.api.usecase

import br.com.unifil.techshop.domain.api.CreateProduct
import br.com.unifil.techshop.domain.api.usecase.CreateProductUseCase
import br.com.unifil.techshop.domain.model.Product
import br.com.unifil.techshop.domain.spi.ProductPort
import br.com.unifil.techshop.persistence.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CreateProductUseCaseTest {

    private val productPort: ProductPort = ProductRepository()
    private val createProduct: CreateProduct = CreateProductUseCase(productPort = productPort)

    @BeforeEach
    fun setup() {
        productPort.deleteAll()
    }

    @Test
    fun `should create product`() {
        //given
        val productToCreate = Product(
            name = "p1",
            price = 10.0
        )
        //when
        val response = this.createProduct.create(product = productToCreate)
        //then
        assertNotNull(response.id)
        assertEquals("p1", response.name)
        assertEquals(10.0, response.price)
    }

}
