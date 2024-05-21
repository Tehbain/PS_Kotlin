package democurrying

fun main() {
    fun mul(x: Int, y: Int): Int = x * y

    println("mul(2, 10) = ${mul(2, 10)}")
    println("mul(5, 10) = ${mul(5, 10)}")
    println()

//    fun mulCurry(x: Int): (Int) -> Int {
//        fun mulX(y: Int): Int {
//            return mul(x, y)
//        }
//        return ::mulX
//    }
//
//    fun mulCurry(x: Int): (Int) -> Int {
//        val mulX = { y: Int -> mul(x, y) }
//        return mulX
//    }

    val mulCurry: (Int) -> ((Int) -> Int) = { x ->
        { y -> mul(x, y) }
    }

    println("mulCurry(2)(10) = ${mulCurry(2)(10)}")
    println("mulCurry(5)(10) = ${mulCurry(5)(10)}")
    println()

    //-----------------------------------------------------

//    fun mul2(y: Int) = mulCurry(2)(y)

    val mul2 = mulCurry(2)

    val a = mul2(10)
    println("mul2(10) = $a")

    val mul5 = mulCurry(5)

    val b = mul5(10)
    println("mul5(10) = $b")
    println()

    //-----------------------------------------------------

    fun exchange(rate: Double, amount: Double): Double = amount / rate
    println("68 kr to USD: ${exchange(6.8, 68.0)}")
    println("75 kr to euro: ${exchange(7.5, 75.0)}")
    println()

    // fun exchangeCurry(rate: Double): (Double) -> Double = { rate: Double -> exchange(rate, amount) }
    val exchangeCurry: (Double) -> ((Double) -> Double) = { rate -> { amount -> exchange(rate, amount) } }

    // 1 USD = 6.8 DKR
    // fun toUSD(amount: Double): Double  = exchangeCurry(6.8)(amount)
    val toUSD: (Double) -> Double = exchangeCurry(6.8)

    // 1 EURO = 7.5 DKR
    // fun toEuro(amount: Double): Double  = exchangeCurry(7.5)(amount)
    val toEuro: (Double) -> Double = exchangeCurry(7.5)

    val usd = toUSD(68.0)
    println("68 kr to USD = $usd")

    val euro = toEuro(75.0)
    println("75 kr to euro = $euro")
}
