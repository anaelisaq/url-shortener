package com.tds.urlshortener.controller

import com.tds.urlshortener.domain.model.Url
import com.tds.urlshortener.service.UrlService
import com.tds.urlshortener.controller.dto.UrlShortenRequest
import com.tds.urlshortener.controller.dto.UrlShortenResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/url-shortener")
@Validated
@Api(tags = ["URL Shortener"])
class UrlController(private val urlService: UrlService) {

    @PostMapping("/shorten")
    @ApiOperation("Shorten a URL")
    fun shortenUrl(@RequestBody @Valid request: UrlShortenRequest): UrlShortenResponse {
        val url = urlService.shortenUrl(request.originalUrl)
        return UrlShortenResponse(url.shortUrl)
    }

    @GetMapping("/{shortUrl}")
    @ApiOperation("Return the short URL for original URL")
    fun redirectToOriginalUrl(@PathVariable shortUrl: String): ResponseEntity<Any> {
        val originalUrl = urlService.getOriginalUrl(shortUrl)
        return if (originalUrl != null){
            ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, originalUrl).build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/statistics")
    @ApiOperation("Shows how many times the shorten URL has used")
    fun getStatistics(@RequestParam(defaultValue = "0") page: Int, @RequestParam(defaultValue = "10") size: Int): ResponseEntity<Page<Url>> {
        val urls = urlService.getStatistics(page = 0, size = 10)
        return ResponseEntity.ok(urls)
    }
}