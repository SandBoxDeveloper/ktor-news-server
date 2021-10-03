package com.andre.routes

import com.andre.data.Article
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private const val BASE_URL = "http://192.168.86.23:8080"
private val articles = listOf(
    Article(
        title = "Tesla New Vehicle",
        description = "A New launched vehicle",
        urlToImage = ""
    ),
    Article(
        title = "Space Force Crew Lands in Space",
        description = "Crew Successfully reach orbit",
        urlToImage = ""
    )
)

fun Route.randomArticleImage() {
    get("/article/images") {
        call.respond(
            HttpStatusCode.OK,
            articles.random()
        )
    }
}