package com.tds.urlshortener.util

import kotlin.random.Random

object UrlShorternerUtil {
    fun generateShortUrl(): String {
        val characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val random = Random.Default
        val shortUrl = StringBuilder()

        repeat(8){
            val index = random.nextInt(characters.length)
            shortUrl.append(characters[index])
        }

        return shortUrl.toString()
    }
}