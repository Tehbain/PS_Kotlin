package operatoroverloading

data class Complex(val real: Double, val imaginary: Double) {

    operator fun plus(another: Complex): Complex {
        return Complex(
            real + another.real,
            imaginary + another.imaginary
        )
    }

    operator fun minus(another: Complex): Complex {
        return Complex(
            real = real - another.real,
            imaginary = imaginary - another.imaginary
        )
    }

    operator fun compareTo(other: Complex): Int {
        val thisLengthSq = this.real * this.real + this.imaginary * this.imaginary
        val otherLengthSq = other.real * other.real + other.imaginary * other.imaginary
        return when {
            thisLengthSq - otherLengthSq < 0 -> -1
            thisLengthSq - otherLengthSq > 0 -> 1
            else -> 0
        }
    }
}

// example usage
fun main() {
    val c1 = Complex(1.0, 2.0)
    val c2 = Complex(2.0, 3.0)
    println(c1 + c2) // Complex(real=3.0, imaginary=5.0)
    println(c2 - c1) // Complex(real=1.0, imaginary=1.0)

    println(if (c1 < c2) "c1 < c2" else "c1 >= c2") // c1 < c2

    val c3 = Complex(2.0,1.0)
    println(c1 == c3) // false
    println(c1.compareTo(c3) == 0) // true
}
