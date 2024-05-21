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
    println("fac.it:  " + reCURSED.fac.it(5)) // = 120
    println("fac.rec: " + reCURSED.fac.rec(5))
    println()
    println("fib.rec(8): " + reCURSED.fib.rec(8)) // = 21

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
            var yeetus: Int = n
            var sum: Int = n
            for (i: Int in 1 .. n-1) {
                sum *= --yeetus
            }
            return sum
        }

        fun rec (n: Int): Int {
            tailrec fun rec(n: Int, acc: Int): Int {
                return if (n == 0 || n == 1) {
                    return acc
                } else {
                    //println(""+n + ": " + ""+acc)
                    rec(n - 1,  acc * (n-1))
                }
            }
            return rec(n-1, n*(n-1))
        }
    }
    object fib {
        fun it(n: Int):Int {
            print(" NO! ")
            return 1337
        }

        fun rec(n: Int): Int {
            tailrec fun rec(n: Int, a: Int, b: Int): Int {
                return when (n) {
                    0 -> a
                    1 -> b
                    else -> rec(n - 1, b, a + b)
                }
            }
            return rec(n, 0, 1)
        }
    }
}