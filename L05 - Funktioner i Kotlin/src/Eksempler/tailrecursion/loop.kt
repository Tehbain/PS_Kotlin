package tailrecursion
// demo

fun main() {

    fun itPrint(n: Int) {
        for (i in 0..n) {
            print("$i  ")
        }
    }

    println("Iterative printing:")
    itPrint(9)
    println()
    println()

    fun recPrint(n: Int) {
        if (n >= 0) {
            recPrint(n - 1)
            print("$n  ")
        }
    }

    println("Recursive printing:")
    recPrint(9)
    println()
    println()

    //-----------------------------------------------------

    fun itSum(n: Int): Int {
        var sumIt = 0
        for (i in 0..n) {
            sumIt += i
            //print("$sumIt  ")
        }
        return sumIt
    }

    println("Iterative summing:")
    val itSum = itSum(9)
    println()
    println("Iterative sum: $itSum")
    println()

    fun recSum(n: Int): Int {
        return if (n >= 0) {
            val res = (recSum(n - 1) + n)
            //print("$res  ")
            res
        } else 0
    }

    println("Recursive summing: ")
    val recSum = recSum(9)
    println()
    println("Recursive sum: $recSum")
    println()
}
