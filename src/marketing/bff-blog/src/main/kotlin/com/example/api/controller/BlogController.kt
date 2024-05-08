package com.example.api.controller

import com.example.api.model.*
import org.springframework.web.bind.annotation.*
import com.example.api.service.BlogService

@RestController
class BlogController(val blogService: BlogService) {

    @GetMapping(
        value = ["/v1/be6d8e56"],
        produces = ["application/json"]
    )
    fun listBlogs(@RequestParam(value = "size", defaultValue = "10") size: Int,
                  @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<BlogResponse>> {
        val request = ListBlogRequest(page = page, size = size)
        val responses = blogService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }
}