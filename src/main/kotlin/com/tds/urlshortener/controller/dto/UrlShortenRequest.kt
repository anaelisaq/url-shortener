package com.tds.urlshortener.controller.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class UrlShortenRequest(
    @field:NotBlank(message = "The original URL can't be blank.")
    @field:Pattern(regexp = "^(https?|ftp)://.*|$", message = "The URL must be valid.")
    val originalUrl: String
)
