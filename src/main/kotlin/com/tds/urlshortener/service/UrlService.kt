package com.tds.urlshortener.service

import com.tds.urlshortener.domain.model.Url
import com.tds.urlshortener.domain.repository.UrlRepository
import com.tds.urlshortener.util.UrlShorternerUtil
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UrlService(private val urlRepository: UrlRepository) {

    @Transactional
    fun shortenUrl(originalUrl: String): Url{
        val shortUrl = UrlShorternerUtil.generateShortUrl()
        val url = Url(originalUrl = originalUrl, shortUrl = shortUrl)
        return urlRepository.save(url)
    }

    @Transactional
    fun getOriginalUrl(shortUrl: String): String? {
        val url = urlRepository.findShortUrl(shortUrl)
        return url?.originalUrl
    }

    @Transactional
    fun registerUrlAccess(shortUrl: String) {
        val url = urlRepository.findShortUrl(shortUrl)
        url?.let {
            it.accessCount++
            urlRepository.save(it)
        }
    }

    @Transactional
    @Cacheable("urlCache")
    fun getStatistics(page: Int, size: Int): Page<Url> {
        val pageable: Pageable = PageRequest.of(page, size)
        return urlRepository.findAll(pageable)
    }
}