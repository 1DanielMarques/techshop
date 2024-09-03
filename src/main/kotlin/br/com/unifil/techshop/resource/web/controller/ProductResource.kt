package br.com.unifil.techshop.resource.web.controller

import br.com.unifil.techshop.api.ProductRequest
import br.com.unifil.techshop.api.ProductResponse
import br.com.unifil.techshop.resource.web.facade.ProductFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/techshop/products")
class ProductResource(
    private val productFacade: ProductFacade
) {

    @PostMapping("/create")
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok().body(this.productFacade.createProduct(request = request))
    }

    @GetMapping("/findAll")
    fun getProducts(): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok().body(productFacade.getProducts())
    }

}
