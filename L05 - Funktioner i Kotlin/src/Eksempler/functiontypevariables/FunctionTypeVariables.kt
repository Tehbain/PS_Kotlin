package functiontypevariables

fun main() {
    // fun function
    fun square(x: Int): Int = x * x
    println(square(4))

    // reference to fun function
    val sqRef = ::square
    println(sqRef(7))

    // anonymous function
    val sqAno: (Int) -> Int = fun(x: Int): Int = x * x
    // val sq1Ano = fun(x: Int): Int = x * x
    println(sqAno(5))

    // lambda function
    val sqLambda: (Int) -> Int = { x -> x * x }
    // val sq1Lambda = { x: Int -> x * x }
    println(sqLambda(6))


    // extension function
    fun Int.square(): Int = this * this
    println(8.square())

    // lambda extension function (aka. lambda with receiver)
    val sq2: Int.() -> Int = { this * this }
    println(9.sq2())
    println()

    val fs: List<(Int) -> Int> = listOf(::square, sqAno, sqLambda, sqRef, Int::square, sq2)
    for (i in fs.indices) {
        println(fs[i](i + 10))
    }
}
