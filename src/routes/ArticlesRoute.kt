package com.andre.routes

import com.andre.data.Article
import com.andre.data.Articles
import com.andre.data.Section
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json

private const val BASE_URL = "http://192.168.86.23:8080"
private const val APP_BASE_URL = "http://0.0.0.0:8080"

@OptIn(ImplicitReflectionSerializer::class, kotlinx.serialization.UnstableDefault::class)
val section = Section(
    title = "Tesla New Vehicle",
    body_elements = listOf(
        Json.Default.toJson(
            """As part of a separate engineering project, the team has also laid the critical foundation for future-proofing the delivery of the Met Office’s services."
                    + "{\n" + "image_url:" + "$APP_BASE_URL/images/tesla_wheel.jpeg" + "\n" + "}"""
        ).toString()
    )
)

private val articles = Articles(
    listOf(
        Article(
            id = 1,
            teaser = "Tesla inc. Release new model.",
            title = "Tesla New Vehicle",
            hero_image = "${APP_BASE_URL}/images/tesla_wheel.jpeg",
            sections = listOf(section)
        ),
        Article(
            id = 2,
            teaser = "The first space force screw has arrived in space.",
            title = "Space Force Crew Lands in Space",
            hero_image = "$APP_BASE_URL/images/space_force.jpeg",
            sections = listOf(section)
        )
    )
)

fun Route.randomArticleImage() {
    get("/article/images") {
        call.respond(
            HttpStatusCode.OK,
            articles
        )
    }
}