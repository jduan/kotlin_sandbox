import geometry.shapes.createRandomRectangle

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
