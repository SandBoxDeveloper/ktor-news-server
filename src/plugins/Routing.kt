package com.andre.plugins

import com.andre.routes.randomArticleImage
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        randomArticleImage()

        // Static feature. Try to access `/static/ktor_logo.svg`
        static {
            resources("static")
        }
    }
}