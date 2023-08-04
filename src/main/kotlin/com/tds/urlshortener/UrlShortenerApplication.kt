package com.tds.urlshortener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
class UrlShortenerApplication

fun main(args: Array<String>) {
	runApplication<UrlShortenerApplication>(*args)
}
