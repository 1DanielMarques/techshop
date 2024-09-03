package br.com.unifil.techshop.domain.api

import br.com.unifil.techshop.domain.model.Product

interface CreateProduct {

    fun create(product: Product): Product

}
