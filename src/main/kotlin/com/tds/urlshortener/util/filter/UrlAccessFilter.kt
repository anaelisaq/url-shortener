package com.tds.urlshortener.util.filter

import com.tds.urlshortener.service.UrlService
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component

@Component
class UrlAccessFilter(private val urlService: UrlService): Filter {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpRequest = request as HttpServletRequest
        val shortUrl = httpRequest.requestURI.substringAfterLast("/")
        urlService.registerUrlAccess(shortUrl)
        chain?.doFilter(request, response)
    }
}