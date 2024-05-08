package com.example.api.service

import com.example.api.model.ListBlogRequest
import com.example.api.model.BlogResponse

interface BlogService {

    fun list(listBlogRequest: ListBlogRequest): List<BlogResponse>
}