/* Lav funktion calc(), som tager op: (Int, Int) → Int som parameter og returnerer en funktion,
som returnerer op() anvendt på x og y.
Brug funktionen op() til at lave 3 funktioner: add(), subtract() og multiply().
Testen i main() kunne se således ud: */
fun main() {
    val add: (Int, Int) -> Int = calc { x, y -> x + y }
    val subtract: (Int, Int) -> Int = calc {x,y -> x - y}
    val multiply: (Int, Int) -> Int = calc{x,y -> x * y}

    println("add(8, 6) = ${add(8, 6)}") // 14
    println("subtract(8, 6) = ${subtract(8, 6)}") // 2
    println("multiply(8, 6) = ${multiply(8, 6)}") // 48
    println()

    println(repeatAction(5,2,2,{it.inc()}))

}

fun calc(op: (Int, Int) -> Int): (Int, Int) -> Int {
    return { x, y -> op(x,y) }
}

/*
Kod funktionen repeatAction() med parametrene times: Int og initial: Int og increment: Int og
action(), som er en funktion, der tager en Int som parameter og ikke returnerer noget.
Metoden skal sørge for at action() udføres times gange. Parameteren til action() skal starte
med værdien af initial og ved hver gentagelse øges med increment.
Hint: Se på Kotlin funktionen repeat(), men først efter at du har forsøgt selv.
 */

fun repeatAction(times: Int, initial: Int, increment: Int, action: (Int) -> Unit) {
    var i = 0
    while (i <= times) {
        action(initial.plus(increment))
        i++
    }
}