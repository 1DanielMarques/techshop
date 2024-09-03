package br.com.unifil.techshop.domain.api.usecase

import br.com.unifil.techshop.domain.api.FindProduct
import br.com.unifil.techshop.domain.model.Product
import br.com.unifil.techshop.domain.spi.ProductPort

class FindProductUseCase(
    private val productPort: ProductPort
): FindProduct {

    override fun findProducts(): List<Product> {
        return this.productPort.findProducts()
    }

}
