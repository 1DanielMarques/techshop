package br.com.unifil.techshop.resource.web.config

import br.com.unifil.techshop.domain.api.CreateProduct
import br.com.unifil.techshop.domain.api.FindProduct
import br.com.unifil.techshop.domain.api.usecase.CreateProductUseCase
import br.com.unifil.techshop.domain.api.usecase.FindProductUseCase
import br.com.unifil.techshop.domain.spi.ProductPort
import br.com.unifil.techshop.persistence.repository.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {

    @Bean
    fun productPort(): ProductPort = ProductRepository()

    @Bean
    fun createProduct(
        productPort: ProductPort
    ): CreateProduct = CreateProductUseCase(productPort = productPort)

    @Bean
    fun findProduct(
        productPort: ProductPort
    ): FindProduct = FindProductUseCase(productPort = productPort)

}
