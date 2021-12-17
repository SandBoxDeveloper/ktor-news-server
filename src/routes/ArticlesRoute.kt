package com.andre.routes

import com.andre.data.Article
//import com.andre.data.CaseStudyItemSectionBodyElement
//import com.andre.data.Section
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.Serializable

private const val BASE_URL = "http://192.168.86.23:8080"
//private val articles = listOf(
//    Article(
//        id = 1,
//        teaser = "",
//        title = "Tesla New Vehicle",
//        hero_image = "",
//        sections = section
//    ),
//    Article(
//        id = 2,
//        teaser = "",
//        title = "Space Force Crew Lands in Space",
//        hero_image = "",
//        sections = section
//        description = "Crew Successfully reach orbit",
//        urlToImage = ""
//    )
//)

val img = Image(
    image_url = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v2/images/decelerator_pitch-roll-2x.jpg"
)

//val section =  Section(
//    title = "Tesla New Vehicle",
//    body_elements = listOf(
//        "hello",
//        img
//    )
//)



//val section =  Section(
//    title = "Tesla New Vehicle",
//    body_elements = listOf(
//        CaseStudyItemSectionBodyElement.SectionText(
//            "hello"
//        ),
//        CaseStudyItemSectionBodyElement.ImageUrl(
//            image_url = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v2/images/decelerator_pitch-roll-2x.jpg"
//        )
//    )
//)


//body_elements = arrayOf("With such a bold hypothesis, it was important to first demonstrate the iPad could be a reliable replacement for existing testing technology. Over the course of just five days, Kin + Carta Create’ engineering team conducted a technical proof-of-concept that demonstrably proved the iPad was up to the task.",
//"The successful, quickfire experiment brought early value and strengthened the business case for a new, more efficient mode of brake testing. With the theory validated, the team then moved from proof-of-concept code to a production-ready app, now called Decelerator, in six short weeks.")

private val articles = listOf(
    Article(
        id = 1,
        teaser = "Tesla inc. Release new model.",
        title = "Tesla New Vehicle",
        hero_image = ""
        //sections = section
    ),
    Article(
        id = 2,
        teaser = "The first space force screw has arrived in space.",
        title = "Space Force Crew Lands in Space",
        hero_image = ""
        //sections = section
    )
)
@Serializable
data class Image(
    val image_url: String
)
//
//val section =  Section(
//    title = "Tesla New Vehicle",
//    body_elements = listOf<String>()
//)

fun Route.randomArticleImage() {
    get("/article/images") {
        call.respond(
            HttpStatusCode.OK,
            articles
        )
    }
}