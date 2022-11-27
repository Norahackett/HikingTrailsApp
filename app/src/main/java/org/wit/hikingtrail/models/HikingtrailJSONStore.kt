package org.wit.hikingtrail.models

import android.content.Context
import android.net.Uri
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import org.wit.hikingtrail.helpers.*
import timber.log.Timber
import java.lang.reflect.Type
import java.util.*

const val JSON_FILE = "hikingtrails.json"
val gsonBuilder: Gson = GsonBuilder().setPrettyPrinting()
    .registerTypeAdapter(Uri::class.java, UriParser())
    .create()
val listType: Type = object : TypeToken<ArrayList<HikingtrailModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class HikingtrailJSONStore(private val context: Context) : HikingtrailStore {

    var hikingtrails = mutableListOf<HikingtrailModel>()

    init {
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override suspend fun findAll(): MutableList<HikingtrailModel> {
        logAll()
        return hikingtrails
    }

    override suspend fun create(hikingtrail: HikingtrailModel) {
        hikingtrail.id = generateRandomId()
        hikingtrails.add(hikingtrail)
        serialize()
    }


    override suspend fun update(hikingtrail: HikingtrailModel) {
        val hikingtrailsList = findAll() as ArrayList<HikingtrailModel>
        var foundHikingtrail: HikingtrailModel? = hikingtrailsList.find { p -> p.id == hikingtrail.id }
        if (foundHikingtrail != null) {
            foundHikingtrail.title = hikingtrail.title
            foundHikingtrail.description = hikingtrail.description
            foundHikingtrail.image = hikingtrail.image
            foundHikingtrail.location = hikingtrail.location
        }
        serialize()
    }

    override suspend fun delete(hikingtrail: HikingtrailModel) {
        val foundHikingtrail: HikingtrailModel? = hikingtrails.find { it.id == hikingtrail.id }
        hikingtrails.remove(foundHikingtrail)
        serialize()
    }
    override suspend fun findById(id:Long) : HikingtrailModel? {
        val foundHikingtrail: HikingtrailModel? = hikingtrails.find { it.id == id }
        return foundHikingtrail
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(hikingtrails, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        hikingtrails = gsonBuilder.fromJson(jsonString, listType)
    }

    private fun logAll() {
        hikingtrails.forEach { Timber.i("$it") }
    }
}

class UriParser : JsonDeserializer<Uri>,JsonSerializer<Uri> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Uri {
        return Uri.parse(json?.asString)
    }

    override fun serialize(
        src: Uri?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src.toString())
    }
}