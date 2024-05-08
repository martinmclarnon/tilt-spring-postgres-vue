package com.example.api.repository

import com.example.api.entity.Blog
import org.springframework.data.jpa.repository.JpaRepository

interface BlogRepository : JpaRepository<Blog, String> {
}