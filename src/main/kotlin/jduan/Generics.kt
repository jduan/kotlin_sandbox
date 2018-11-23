package jduan.generics

import java.lang.IllegalArgumentException

fun runGenerics() {
  val letters = ('a' .. 'z').toList()
  println(letters.slice<Char>(0..2))
  println(letters.slice(10..13))

  val authors = listOf("Dmitry", "Svetlana")
  val readers = mutableListOf<String>("Jingjing", "John")

  println(readers.filter { it !in authors })

  println(listOf(1, 2, 3).sum())

  println("oneHalf: ${oneHalf(4)}")

  println("max of Kotlin and Java is ${max("Kotlin", "Java")}")

  val helloWorld = StringBuilder("Hello World")
  ensureTrailPeriod(helloWorld)
  println(helloWorld)

  printSum(listOf(1, 2, 3))
  // The line below would throw an IllegalArgumentException
  // printSum(setOf(1, 2, 3))
  // The line below would throw a ClassCastException
  // printSum(listOf("a", "b", "c"))

  printSum2(listOf(1, 2, 3))

  println(isA<String>("abc"))
  println(isA<String>(123))

  val items = listOf("one", 2, "three")
  val itemsString: List<String> = items.filterIsInstance<String>()
  println(itemsString)
}

fun <T: Number> oneHalf(value: T): Double {
  return value.toDouble() / 2.0
}

// The upper bound for T is a generic type Comparable<T>.
fun <T: Comparable<T>> max(first: T, second: T): T =
    if (first > second) first else second

// Specify multiple constraints for a type parameter.
fun <T> ensureTrailPeriod(seq: T) where T : CharSequence, T : Appendable {
  if (!seq.endsWith('.'))
    seq.append('.')
}

fun printSum(c: Collection<*>) {
  val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
  println(intList.sum())
}

fun printSum2(c: Collection<Int>) {
  if (c is List<Int>) {
    println(c.sum())
  }
}

inline fun <reified T> isA(value: Any) = value is T
