import geometry.colors.Color
import geometry.shapes.createRandomRectangle
import geometry.colors.*
import other.exceptions.readNumber
import other.expr.*;
import other.loop.*;
import other.collections.*;
import other.interfaces.*;
import other.extensions.lastChar as last;
import java.io.BufferedReader
import java.io.StringReader

data class Person(val name: String,
                  // null by default
                  val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice", 30),
            Person(name = "John"),
            Person("Bob", age = 29))
    // "it" is the default name of lambda parameter
    // "?:" is called the Elvis operator
    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")

    val rect = Rectangle(3, 4)
    println(rect.isSquared)
    println(createRandomRectangle().isSquare)
    println(getMnemonic(Color.BLUE))
    println(getMnemonic(Color.BLUE))
    println(mix(Color.BLUE, Color.YELLOW))
    println(eval(Sum(Num(1), Num(2))))
    println(eval2(Sum(Num(1), Num(2))))
    testLoops()
    iterateMap()
    iterateList()
    println(recognize('$'))
    readNumber(BufferedReader(StringReader("not a number")))

    // collections
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println("is 1 in the set? ${1 in set}")
    println("last element of list: ${list.last()}")
    println("max element of set: ${set.max()}")

    println(list.joinToString())

    println("Kotlin".last())

    // extension properties
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    Button().showOff()

    println(TwitterUser("Jingjing", "Duan").nickname)
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

data class Person2 (var name: String,
                    var isMarried: Boolean)

fun printPerson2(person: Person2) {
    // in java: person.setName("John")
    person.name = "John"
    // in java: person.getName()
    println(person.name)
    // in java: person.setMarried(false)
    person.isMarried = false
    // in java: person.isMarried()
    println(person.isMarried)
}

class Rectangle(val height: Int, val width: Int) {
    val isSquared: Boolean
        get() {
            return height == width
        }
}
