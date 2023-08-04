package com.tds.urlshortener.domain.model
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.time.LocalDateTime

@Entity()
data class Url(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val originalUrl: String,

    @Column(nullable = false, unique = true)
    val shortUrl: String,

    @Column(nullable = false)
    val createdDate: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var accessCount: Long =0

)
