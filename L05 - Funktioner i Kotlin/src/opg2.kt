/* Opgave 2
Skriv en ’fun’ extension function isDivisible() på Int klassen. Funktionen skal returnere, om
en anden Int går op.
Skriv en lambda extension function (aka. lambda med receiver) på Int klassen med samme
funktionalitet.
Skriv en ’fun’ funktion, der beregner gennemsnittet af en ikke-tom liste af tal. Skriv den
samme mtode, men som en lambda funktion. */

fun main() {
    val x: Int = 5; val y: Int = 10
    println("REG: 10 går op i 5? " + 10.isDivisibleReg(5))
    println("REG: 5 går op i 10? " + 5.isDivisibleReg(10))
    println("REG: 7 går op i 10? " + 10.isDivisibleReg(7))
    println()

    val isDivisibleLambda: Int.(Int) -> Boolean = { other ->
        var x: Int = this
        var y: Int = other
        if (y > x) {
            y % x == 0
        } else x % y == 0
    }
    println("LAM: 5 går op i 10? " + 10.isDivisibleLambda(5))
    println("LAM: 7 går op i 10? " + 10.isDivisibleLambda(7))
    println()

    val avgLambda: List<Int>.() -> Int = {
        var sum = 0
        for (dims in this) {
            sum += dims
        }
        sum / this.size
    }

    val numbers: List<Int> = listOf(1,7,4,7,9,6,5,7,8,34,4,7,6,4,6,76,34)
    println("En liste af tal: " + numbers)
    println("Gennemsnittet af listens indhold, regulær: " + numbers.avg())
    println("Gennemsnittet af listens indhold, lambda:  " + avgLambda(numbers))


}

fun Int.isDivisibleReg(other: Int): Boolean {
    var x: Int = this
    var y: Int = other
    if (y > x) {
        val temp = y
        y = x
        x = temp
    }
    return (x % y == 0)
}

fun List<Int>.avg(): Int {
    var sum = 0
    for (dims in this) {
        sum += dims
    }
    return sum / this.size
}

