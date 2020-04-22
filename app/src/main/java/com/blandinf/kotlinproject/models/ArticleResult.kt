package com.blandinf.kotlinproject.models

data class ArticleResult(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)