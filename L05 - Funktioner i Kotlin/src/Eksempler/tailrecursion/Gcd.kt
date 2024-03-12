package tailrecursion
// demo

tailrec fun gcd(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    } else {
        return gcd(b, a % b)
    }
}

fun main() {
    println("gcd(30,84) = ${gcd(30, 84)}")
    println("gcd(84,30) = ${gcd(84, 30)}")
}
/*
Recursion tree:
    gcd(30,84)  -->  gcd((84,30)  -->  gcd(30,24)  -->  gcd(24,6)  -->  gcd(6,0) = 6
*/
