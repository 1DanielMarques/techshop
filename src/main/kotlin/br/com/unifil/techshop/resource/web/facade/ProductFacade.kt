package br.com.unifil.techshop.resource.web.facade

import br.com.unifil.techshop.api.ProductRequest
import br.com.unifil.techshop.api.ProductResponse
import br.com.unifil.techshop.domain.api.CreateProduct
import br.com.unifil.techshop.domain.api.FindProduct
import br.com.unifil.techshop.resource.web.converter.ProductConverter
import org.springframework.stereotype.Component

@Component
class ProductFacade(
    private val productConverter: ProductConverter,
    private val createProduct: CreateProduct,
    private val findProduct: FindProduct
) {

    fun createProduct(request: ProductRequest): ProductResponse {
        val product = this.productConverter.requestToProduct(request)
        val createdProduct = this.createProduct.create(product = product)
        return this.productConverter.productToResponse(createdProduct)
    }

    fun getProducts(): List<ProductResponse> {
        val products = this.findProduct.findProducts()
        return products.map { product -> this.productConverter.productToResponse(product = product) }
    }

}
