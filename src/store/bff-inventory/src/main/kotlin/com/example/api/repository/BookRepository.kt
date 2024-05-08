package com.example.api.repository

import com.example.api.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, String> {
}