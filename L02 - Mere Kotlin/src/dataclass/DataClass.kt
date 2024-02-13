package dataclass

data class Player(
    val id: Int,
    val name: String,
) {
    var points: Int = 0
}

fun main() {
    val p1 = Player(1, "Ib").apply { points = 123 }
    println(p1) // Player(id=0, name=Ib)
    val p2 = Player(2, "Per").apply { points = 100 }
    println(p2) // Player(id=1, name=Per)
    val p3 = Player(1, "Ib").apply { points = 100 }
    println(p3) // Player(id=1, name=Per)
    println()

    println("p1 == p2? ${p1 == p2}")
    println("p1 == p3? ${p1 == p3}")
    println()

    val set = mutableSetOf(p1,p2)
    println(set)
    set.add(p3)
    println(set)
}
