package com.example.api.service

import com.example.api.model.ListBookRequest
import com.example.api.model.BookResponse

interface BookService {

    fun list(listBookRequest: ListBookRequest): List<BookResponse>
}