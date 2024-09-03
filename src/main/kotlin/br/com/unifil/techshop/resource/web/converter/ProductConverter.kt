package br.com.unifil.techshop.resource.web.converter

import br.com.unifil.techshop.api.ProductRequest
import br.com.unifil.techshop.api.ProductResponse
import br.com.unifil.techshop.domain.model.Product
import org.springframework.stereotype.Component

@Component
class ProductConverter {

    fun requestToProduct(request: ProductRequest): Product {
        return Product(
            name = request.name,
            price = request.price
        )
    }

    fun productToResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id ?: "",
            name = product.name,
            price = product.price
        )
    }

}
