package com.example.api.service.impl

import com.example.api.entity.Book
import com.example.api.model.BookResponse
import com.example.api.model.ListBookRequest
import com.example.api.repository.BookRepository
import com.example.api.service.BookService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BookServiceImpl(
    val bookRepository: BookRepository,
) : BookService {
    override fun list(listBookRequest: ListBookRequest): List<BookResponse> {
        val page = bookRepository.findAll(PageRequest.of(listBookRequest.page, listBookRequest.size))
        val books: List<Book> = page.get().collect(Collectors.toList())
        return books.map { convertBookToBookResponse(it) }
    }

    private fun convertBookToBookResponse(book: Book): BookResponse {
        return BookResponse(
            id = book.id,
            title = book.title,
            isbn = book.isbn,
            author = book.author,
            publisher = book.publisher,
            publishedDate = book.publishedDate,
            numberOfPages = book.numberOfPages,
            languageWrittenIn = book.languageWrittenIn,
            review = book.review
        )
    }
}