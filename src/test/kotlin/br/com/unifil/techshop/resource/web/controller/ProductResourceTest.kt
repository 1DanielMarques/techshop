package br.com.unifil.techshop.resource.web.controller

import br.com.unifil.techshop.api.ProductRequest
import br.com.unifil.techshop.api.ProductResponse
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.*
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductResourceTest(
    @Autowired val restTemplate: TestRestTemplate
) {

    @LocalServerPort
    private var port: Int = 0

    private fun getRootUrl() = "http://localhost:$port/techshop/products"

    @Test
    fun `createProduct should return the created product`() {
        val request = ProductRequest("Product 1", 10.0)
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val entity = HttpEntity(request, headers)

        val response: ResponseEntity<ProductResponse> = restTemplate.postForEntity(
            "${getRootUrl()}/create", entity, ProductResponse::class.java
        )

        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
        assertEquals("Product 1", response.body?.name)
    }

    @Test
    fun `getProducts should return a list of products`() {
        // Create a product first
        val createRequest = ProductRequest(name = "Product 1", price = 10.0)
        restTemplate.postForEntity("${getRootUrl()}/create", createRequest, ProductResponse::class.java)

        val response: ResponseEntity<List<*>> = restTemplate.getForEntity("${getRootUrl()}/findAll", List::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
        assertEquals(1, response.body?.size)
    }

}
