package br.com.unifil.techshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TechshopApplication

fun main(args: Array<String>) {
	runApplication<TechshopApplication>(*args)
}
