/* Opgave 1
Skriv 3 udgaver af en funktion, som returnerer summen af tallene 1..n : en iterativ funktion,
en almindelig rekursiv funktion og en tail rekursiv funktion.
Skriv 3 udgaver af fakultet-funktionen (fak(n) = n!): en iterativ funktion, en almindelig
rekursiv funktion og en tail rekursiv funktion.
Skriv 3 udgaver af fibonacci-funktionen (fib(n) = fib(n-1)+fib(n-2)): en iterativ funktion, en
almindelig rekursiv funktion og en tail rekursiv funktion.
Skriv en iterativ og en tail rekursiv metode, der returnerer, om elementerne i en liste er
stigende. */
fun main() {
    println("rangeSumIt:   " + reCURSED.sumRange.it(5))
    println("rangeSumTrec: " + reCURSED.sumRange.rec(5))
    println()
    println("fac.it: " + reCURSED.fac.it(5))

    //reCURSED.fac
}
class reCURSED {
    object sumRange {
        fun it (n: Int): Int {
            var sum: Int = 0
            for (n: Int in 1..n) {
                sum += n
            }
            return sum
        }

        fun rec(n: Int): Int {
            tailrec fun rec(n: Int, acc: Int): Int {
                return if (n == 0) acc
                else rec(n - 1, acc + n)
            }
        return rec(n, 0)
        }
    }
    object fac {
        fun it (n: Int): Int {
            return 0
        }
    }


}