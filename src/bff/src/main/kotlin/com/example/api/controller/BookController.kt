package com.example.api.controller

import com.example.api.model.*
import org.springframework.web.bind.annotation.*
import com.example.api.service.BookService

@RestController
class BookController(val bookService: BookService) {

    @CrossOrigin(origins = ["http://localhost:8082"])
    @GetMapping(
        value = ["/v1/ad6b8f65"],
        produces = ["application/json"]
    )
    fun listBooks(@RequestParam(value = "size", defaultValue = "10") size: Int,
                  @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<BookResponse>> {
        val request = ListBookRequest(page = page, size = size)
        val responses = bookService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }
}