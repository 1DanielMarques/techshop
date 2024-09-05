package br.com.unifil.techshop.domain.api.usecase

import br.com.unifil.techshop.domain.api.CreateProduct
import br.com.unifil.techshop.domain.model.Product
import br.com.unifil.techshop.domain.spi.ProductPort

class CreateProductUseCase(
    private val productPort: ProductPort
) : CreateProduct {

    override fun create(product: Product): Product {
        //cria produto
        return this.productPort.createProduct(product = product)
    }

}
