package com.tds.urlshortener.unit

import com.tds.urlshortener.domain.model.Url
import com.tds.urlshortener.domain.repository.UrlRepository
import com.tds.urlshortener.service.UrlService
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UrlServiceTest {
    private val urlRepository: UrlRepository = mockk()
    private val urlService: UrlService = UrlService(urlRepository)

    @Test
    fun `shortenUrl should save and return Url with shortUrl`(){
        val originalUrl = "https://www.example.com"
        val shortUrl = "abc123"
        val url = Url(originalUrl = originalUrl, shortUrl = shortUrl)

        every { urlRepository.save(any()) } returns url

        val result = urlService.shortenUrl(originalUrl)

        assertThat(result.originalUrl).isEqualTo(originalUrl)
        assertThat(result.shortUrl).isEqualTo(shortUrl)
    }

    @Test
    fun `getOriginalUrl should return originalUrl when shortUrl exists`() {
        val shortUrl = "abc123"
        val originalUrl = "https://example.com"
        val url = Url(originalUrl = originalUrl, shortUrl = shortUrl)

        every { urlRepository.findShortUrl(shortUrl) } returns url

        val result = urlService.getOriginalUrl(shortUrl)

        assertThat(result).isEqualTo(originalUrl)
    }

    @Test
    fun `getOriginalUrl should return null when shortUrl does not exist`() {
        val shortUrl = "nonExistent"

        every { urlRepository.findShortUrl(shortUrl) } returns null

        val result = urlService.getOriginalUrl(shortUrl)

        assertThat(result).isNull()
    }
}