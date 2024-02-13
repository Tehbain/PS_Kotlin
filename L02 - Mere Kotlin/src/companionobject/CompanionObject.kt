package companionobject

abstract class Money(
    val amount: Double,
    val currency: String
) {
    override fun toString(): String {
        return "%.2f %s".format(amount, currency)
    }
}

class USD(amount: Double) : Money(amount, "USD") {
    companion object {
        const val rate = 6.8 // 1 $ = 6.8 DKR
        fun fromDKR(amount: Double): USD = USD(amount/rate)
    }
}

class EUR(amount: Double) : Money(amount, "EUR") {
    companion object {
        const val rate = 7.5
        fun fromDKR(amount: Double): EUR = EUR(amount/rate)
    }
}

fun main() {
    val eur: EUR = EUR.fromDKR(12.0)
    println("$eur")
    val usd: USD = USD.fromDKR(32.0)
    println(usd)

}
