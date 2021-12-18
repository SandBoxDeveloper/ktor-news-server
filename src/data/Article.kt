package com.andre.data

import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer

@Serializable
data class Articles(
    val articles: List<Article>
)

@Serializable
data class Article(
    val id: Int,
    val teaser: String,
    val title: String,
    val hero_image: String,
    val sections: List<Section>
)

@Serializable
data class Section(
    val title: String,
    @Serializable(with = UserListSerializer::class)
    val body_elements: List<String>
)

@Serializable
@SerialName("CaseStudyItemSectionBodyElement")
sealed class CaseStudyItemSectionBodyElement {

    @Serializable
    data class ImageUrl(
        val image_url: String
    ) : CaseStudyItemSectionBodyElement()
}
//
//@Serializer(forClass = CaseStudyItemSectionBodyElement::class)
//object SectionBodyElementSerializer : KSerializer<List<CaseStudyItemSectionBodyElement>> {
//
//    override val descriptor: SerialDescriptor = CaseStudyItemSectionBodyElement.serializer().descriptor
//
//    override fun deserialize(decoder: Decoder): List<CaseStudyItemSectionBodyElement> {
//        TODO("Not yet implemented")
//    }
//
//    override fun serialize(encoder: Encoder, value: List<CaseStudyItemSectionBodyElement>) {
//
//        JsonPrimitive("soemthing new")
//        value.forEach {
//            when (it) {
//                is CaseStudyItemSectionBodyElement.ImageUrl -> {
//
//                    encoder.encodeSerializableValue(
//                        CaseStudyItemSectionBodyElement.serializer(),
//                        CaseStudyItemSectionBodyElement.ImageUrl(it.image_url)
//                    )
//                }
//            }
//        }
//    }
//
//}

@Serializer(forClass = String::class)
object SectionBodyElementSerializer : KSerializer<List<String>> {

    override val descriptor: SerialDescriptor = String.serializer().descriptor

    override fun deserialize(decoder: Decoder): List<String> {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: List<String>) {
        encoder.encodeString(value.toString())
    }

}

object UserListSerializer : JsonTransformingSerializer<List<String>>(
    ListSerializer(String.serializer()),
    "name"
) {
    // If response is not an array, then it is a single object that should be wrapped into the array
    override fun writeTransform(element: JsonElement): JsonElement {
        return element.jsonArray
    }
}

//object UserListSerializer : JsonTransformingSerializer<List<CaseStudyItemSectionBodyElement>>(
//    ListSerializer(CaseStudyItemSectionBodyElement.serializer()),
//    "name"
//) {
//    // If response is not an array, then it is a single object that should be wrapped into the array
//    override fun writeTransform(element: JsonElement): JsonElement {
//        return element.jsonArray
//    }
//}
