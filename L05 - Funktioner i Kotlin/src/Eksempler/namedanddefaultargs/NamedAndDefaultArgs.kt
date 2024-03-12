package namedanddefaultargs

fun main() {

    fun printLine(line: String = "-", end: String = "!") = println("$line$end")

    printLine("Hello, Kotlin", "!!!") // prints "Hello, Kotlin!!!"
    printLine(end ="!!!", line = "Hello, Kotlin") // prints "Hello, Kotlin!!!"
    printLine("Kotlin") // prints "Kotlin!"
    printLine(end = "!!!") // prints "-!!!"
    printLine() // prints "-!"
}
