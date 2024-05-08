package com.example.api.service.impl

import com.example.api.entity.Blog
import com.example.api.model.BlogResponse
import com.example.api.model.ListBlogRequest
import com.example.api.repository.BlogRepository
import com.example.api.service.BlogService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BlogServiceImpl(
    val blogRepository: BlogRepository,
) : BlogService {
    override fun list(listBlogRequest: ListBlogRequest): List<BlogResponse> {
        val page = blogRepository.findAll(PageRequest.of(listBlogRequest.page, listBlogRequest.size))
        val blogs: List<Blog> = page.get().collect(Collectors.toList())
        return blogs.map { convertBlogToBlogResponse(it) }
    }

    private fun convertBlogToBlogResponse(blog: Blog): BlogResponse {
        return BlogResponse(
            id = blog.id,
            post = blog.post,
        )
    }
}