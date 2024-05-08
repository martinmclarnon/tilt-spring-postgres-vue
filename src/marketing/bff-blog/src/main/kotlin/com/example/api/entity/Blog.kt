package com.example.api.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "blog")
data class Blog(

    @Id
    val id: String,

    @Column(name = "post")
    val post: String

)
