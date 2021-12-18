package com.andre.plugins

import com.andre.routes.randomArticleImage
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        randomArticleImage()

        get("/headers") {
            call.response.headers.append("server-name", "KtorServer")
            call.response.headers.append("chocolate", "I love it.")
            call.respondText("Headers Attached")
        }

        static {
            resources("static")
        }
    }
}