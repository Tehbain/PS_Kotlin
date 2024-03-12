package tailrecursion
// demo

fun sumListIt(list: List<Int>): Int {
    var sum = 0
    for (item in list) {
        sum += item
    }
    return sum
}
//---------------------------------------------------------
fun sumListRec(list: List<Int>): Int {
    if (list.isEmpty()) {
        return 0
    } else {
        return list.first() + sumListRec(list.drop(1))
    }
}
//---------------------------------------------------------
fun sumListTail(list: List<Int>): Int {
    return sumList(list, 0)
}

private tailrec fun sumList(list: List<Int>, acc: Int): Int {
    if (list.isEmpty()) {
        return acc
    } else {
        return sumList(list.drop(1), acc + list.first())
    }
}
//---------------------------------------------------------
fun sumListRecIndexed(list: List<Int>): Int {

    fun sumList(i: Int): Int {
        if (i == list.lastIndex) {
            return list[i]
        } else {
            return list[i] + sumList(i + 1)
        }
    }

    return if (list.isEmpty()) 0 else sumList(0)
}
//---------------------------------------------------------
fun sumListTailIndexed(list: List<Int>): Int {

    tailrec fun sumList(i: Int, acc: Int): Int {
        if (i > list.lastIndex) {
            return acc
        } else {
            return sumList(i + 1, acc + list[i])
        }
    }

    return if (list.isEmpty()) 0 else sumList(0, 0)
}
//---------------------------------------------------------

fun main() {
    val numbers = listOf(2, 5, 8, 12)
    println(numbers)

    val sumIt = sumListIt(numbers)
    println("sumIt = $sumIt")

    val sumRec = sumListRec(numbers)
    println("sumRec = $sumRec")

    val sumTail = sumListTail(numbers)
    println("sumTail = $sumTail")

    val sumRecIndexed = sumListRecIndexed(numbers)
    println("sumRecIndexed = $sumRecIndexed")

    val sumTailIndexed = sumListTailIndexed(numbers)
    println("sumTailIndexed = $sumTailIndexed")
}

/*
    Recursion tree for sumListRec([4,3,2,1]):
    sLR([4,3,2,1])
    |-> 4 + sLR([3,2,1])
            |-> 3 + sLR([2,1])
                    |-> 2 + sr([1])
                            |-> 1 + sLR([])
                                    |-> 0
    10 <-   6 <-    3 <-    1 <-

    Recursion tree for sumListTail([4,3,2,1]):
    sLT([4,3,2,1], 0) -> sLT([3,2,1], 0+4) -> sLT([2,1], 0+4+3) ->
                         sLT([1], 0+4+3+2) -> sLT([], 0+4+3+2+1) -> 0+4+3+2+1
*/
