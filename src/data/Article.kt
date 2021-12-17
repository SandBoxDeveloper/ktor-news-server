package com.andre.data

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable

@Serializable
data class Articles(
    val articles: List<Article>
)

@Serializable
data class Article(
    val id: Int,
    val teaser: String,
    val title: String,
    val hero_image: String
    //val sections: Section
)

//@Serializable
//data class Article(
//    val id: Int,
//    val teaser: String,
//    val title: String,
//    val hero_image: String
//)

//@Serializable
//@ContextualSerialization
//data class Section(
//    val title: String,
//    val body_elements: List<Any>
//)

//@Serializable
//sealed class CaseStudyItemSectionBodyElement {
//
//    @Serializable
//    data class SectionText(
//        val sectionText: String
//    ) : CaseStudyItemSectionBodyElement()
//
//    @Serializable
//    data class ImageUrl(
//        val sectionText: String? = null,
//        val image_url: String
//    ) : CaseStudyItemSectionBodyElement()
//}
