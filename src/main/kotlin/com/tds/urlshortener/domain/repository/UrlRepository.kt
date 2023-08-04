package com.tds.urlshortener.domain.repository

import com.tds.urlshortener.domain.model.Url
import org.springframework.data.jpa.repository.JpaRepository

interface UrlRepository : JpaRepository<Url, Long> {
    fun findShortUrl(shortUrl: String): Url?
}