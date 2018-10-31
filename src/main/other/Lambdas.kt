package main.other.lambdas

data class Person(val name: String, val age: Int)

fun findOldestPerson(): Person? {
    val people = listOf(Person("Alice", 29), Person("Bob", 33))
    // return people.maxBy { it.age }
    return people.maxBy(Person::age) // member reference
}


