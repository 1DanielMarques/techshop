package br.com.unifil.techshop.domain.api

import br.com.unifil.techshop.domain.model.Product

interface FindProduct {

    fun findProducts(): List<Product>

}
