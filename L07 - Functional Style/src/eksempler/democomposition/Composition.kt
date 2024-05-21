package democomposition

fun main() {
    val square: (Double) -> Double = { x -> x * x }
    val triple: (Int) -> Double = { x -> x * 3.0 }
    println("square(triple(2)) = ${square(triple(2))}")
    println()

//    fun compose(f: (Double) -> Double, g: (Int) -> Double): (Int) -> Double = { x -> f(g(x)) }
    val compose: ((Double) -> Double, (Int) -> Double) -> (Int) -> Double =
        { f, g -> { x -> f(g(x)) } }
//    val compose = { f: (Double) -> Double, g: (Int) -> Double -> { x: Int -> f(g(x)) } }

    val sqAfterTr = compose(square, triple)
    println("sqAfterTr(2) = ${sqAfterTr(2)}")
    println()

    fun <T, U, V> composeGen(f: (U) -> V, g: (T) -> U): (T) -> V = { x -> f(g(x)) }
    val sqAfterTrGen = composeGen(square, triple)
    println("sqAfterTrGen(2) = ${sqAfterTrGen(2)}")
    println()

    //-----------------------------------------------------

    val composeCurry =
        { f: (Double) -> Double ->
            { g: (Int) -> Double ->
                { x: Int -> f(g(x)) }
            }
        }

    fun <T, U, V> composeGenCurry() =
        { f: (U) -> V ->
            { g: (T) -> U ->
                { x: T -> f(g(x)) }
            }
        }

    val composeCurrySq = composeCurry(square)

    println("sqAfterTrCurry(2) = ${composeCurrySq(triple)(2)}")
    println("sqAfterLinearCurry(2) = ${composeCurrySq { x: Int -> 2.0 * x + 3.0 }(2)}")
    println()

    val composeGenCurrySq = composeGenCurry<Int, Double, Double>()(square)

    println("sqAfterTrGenCurry(2) = ${composeGenCurrySq(triple)(2)}")
    println("sqAfterLinearGenCurry(2) = ${composeGenCurrySq { x: Int -> 2.0 * x + 3.0 }(2)}")
}
