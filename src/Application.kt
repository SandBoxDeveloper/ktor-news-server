package com.andre

import com.andre.plugins.configureMonitoring
import com.andre.plugins.configureRouting
import com.andre.plugins.configureSerialization
import io.ktor.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}

