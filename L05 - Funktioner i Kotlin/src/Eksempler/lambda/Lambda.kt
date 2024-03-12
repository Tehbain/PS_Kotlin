package lambda

fun main() {
    val add: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    // val add: (Int, Int) -> Int = { x, y -> x + y }
    // val add = { x: Int, y: Int -> x + y }
    println(add(3, 4))
    println()

    val strings = listOf("Ib", "Ulla", "Hans", "Pia")
    println(strings)
    println(strings.filter { str -> str.length == 4 })
    // println(strings.filter { it.length == 4 }) // use it for parameter in lambda
    // println(strings) // strings is unchanged
    println()

    val numbers = listOf(1, 6, -3, 8, 9, 0, -1, 8)
    var sum = 0
    numbers.forEach {
        sum += it // captured variable sum (closure)
    }
    println(sum)
    println()
}
