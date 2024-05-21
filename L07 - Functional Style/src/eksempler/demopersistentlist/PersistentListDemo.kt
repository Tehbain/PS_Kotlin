package demopersistentlist

sealed class PList<T> {
    abstract fun isEmpty(): Boolean

    private object Nil : PList<Nothing>() {
        override fun isEmpty(): Boolean = true
    }

    private class Cons<T>(val head: T, val tail: PList<T>) : PList<T>() {
        override fun isEmpty(): Boolean = false
    }

    override fun toString(): String {
        tailrec fun toString(list: PList<T>, acc: String): String = when (list) {
            is Nil -> acc + "Nil"
            is Cons -> toString(list.tail, acc + list.head.toString() + "->")
        }
        return toString(this, "")
    }

    fun cons(t: T): PList<T> = Cons(t, this)

    fun head(): T = when (this) {
        is Nil -> throw IllegalStateException("head() called on empty list")
        is Cons -> head
    }

    fun tail(): PList<T> = when (this) {
        is Nil -> throw IllegalStateException("tail() called on empty list")
        is Cons -> tail
    }

    fun dropWhile(predicate: (T) -> Boolean): PList<T> {
        tailrec fun dropWhile(list: PList<T>): PList<T> =
            when (list) {
                is Nil -> list
                is Cons ->
                    if (predicate(list.head)) dropWhile(list.tail)
                    else list
            }
        return dropWhile(this)
    }

    fun concat(list: PList<T>): PList<T> =
        when (this) {
            is Nil -> list
            is Cons -> Cons(this.head, this.tail.concat(list))
        }

    companion object {
        @Suppress("UNCHECKED_CAST")
        operator fun <T> invoke(t: T): PList<T> = Cons(t, Nil as PList<T>)

        @Suppress("UNCHECKED_CAST")
        operator fun <T> invoke(): PList<T> = Nil as PList<T>
    }
}

fun main() {
    val list: PList<String> = PList("Ib").cons("Per").cons("Hans")
    println("list: $list")           // list: Hans->Per->Ib->Nil
    println("head: ${list.head()}")  // head: Hans
    println("tail: ${list.tail()}")  // tail: Per->Ib->Nil
    println()

    val list4 = list.dropWhile { it.length >= 3 }
    println("After dropWhile { it.length >= 3 }:")
    println("list: $list")   // list: Hans->Per->Ib->Nil
    println("list4: $list4") // list4: Ib->Nil
    println()

    val list5 = PList("Lene").cons("Pia").cons("Ulla")
    val list6 = PList("Marie").cons("Luna")
    val list7 = list5.concat(list6)
    println("After list5.concat(list6):")
    println("list5: $list5") // list5: Ulla->Pia->Lene->Nil
    println("list6: $list6") // list6: Luna->Marie->Nil
    println("list7: $list7") // list7: Ulla->Pia->Lene->Luna->Marie->Nil
    println()

    fun PList<Int>.sum(): Int {
        tailrec fun sum(acc: Int, list: PList<Int>): Int =
            when {
                list.isEmpty() -> acc
                else -> sum(acc + list.head(), list.tail())
            }
        return sum(0, this)
    }

    val list12 = PList(2).cons(8).cons(6)
    val sum = list12.sum()
    println("After sum():")
    println("list12: $list12") // list12: 6->8->2->Nil
    println("sum: $sum")       // sum: 16
    println()
}
