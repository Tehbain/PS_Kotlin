package hof

fun main() {
    // calcInt() is a HOF with a function op() as parameter
    fun calcInt(a: Int, b: Int, op: (Int, Int) -> Int): Int {
        return op(a, b)
    }

    val sum = calcInt(2, 3) { x, y -> x + y }
    println("Using calcInt. $sum") // Output: 5
    println()

    // mathOp() is a HOF returning a lambda function
    fun mathOp(type: String): (Int, Int) -> Int {
        return when (type) {
            "+" -> { x, y -> x + y }
            "-" -> { x, y -> x - y }
            else -> { _, _ -> 0 }
        }
    }

    val sumOp = mathOp("+")
    println("Using sumOp: ${sumOp(4, 5)}") // Output: 9
    println()

    // HOF with extension function on StringBuilder as parameter
    fun makeString(init: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        sb.apply(init)
        return sb.toString()
    }
    // makeString() used with lambda with receiver,
    // where the receiver (StringBuilder) is inferred from the context
    val str = makeString {
        append("Hello")
        append(", ")
        append("World!")
    }
    println(str) // Hello, World!
}
