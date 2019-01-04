package jduan.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

// Car has an Engine field.
data class Car(val color: String, val type: String, val engine: Engine)

data class Engine(val power: Int)

fun main(args: Array<String>) {
    objectToJSON()
    jsonToObject()
}

private fun objectToJSON() {
    val objectMapper = ObjectMapper()
    val car = Car("yellow", "renault", Engine(300))
    // objectMapper.writeValue(System.out, car)
    // or
    println("json string: ${objectMapper.writeValueAsString(car)}")
}

private fun jsonToObject() {
    val objectMapper = jacksonObjectMapper()
    val jsonString = """
        {
          "color": "Black",
          "type": "BMW",
          "engine": {
            "power": 300
          }
        }
    """.trimIndent()
    val car = objectMapper.readValue<Car>(jsonString)
    println(car)
}
