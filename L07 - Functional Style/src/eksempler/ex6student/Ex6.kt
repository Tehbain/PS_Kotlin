package ex6student

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

    companion object {
        @Suppress("UNCHECKED_CAST")
        operator fun <T> invoke(t: T): PList<T> = Cons(t, Nil as PList<T>)

        @Suppress("UNCHECKED_CAST")
        operator fun <T> invoke(): PList<T> = Nil as PList<T>
    }

    fun size(): Int {
        TODO()
    }

    fun replaceHead(t: T): PList<T> {
        TODO()
    }

    fun drop(n: Int): PList<T> {
        TODO()
    }

    fun reverse(): PList<T> {
        TODO()
    }

    fun <R> fold(initial: R, operation: (acc: R, T) -> R): R {
        TODO()
    }
}

fun main() {
    val list: PList<String> = PList("Ib").cons("Per").cons("Hans")
    println("list: $list")           // list: Hans->Per->Ib->Nil
    println("head: ${list.head()}")  // head: Hans
    println("tail: ${list.tail()}")  // tail: Per->Ib->Nil
    println("size: ${list.size()}")  // size: 3
    println()

    val list1 = list.replaceHead("Ulla")
    println("After replaceHead():")
    println("list: $list")   // list: Hans->Per->Ib->Nil
    println("list1: $list1") // list1: Ulla->Per->Ib->Nil
    println()

//    val list2 = List<String>()
//    println("list2: $list2") // list2: Nil
//    list2.replaceHead("x") // throws IllegalStateException
//    println()

    val list3 = list.drop(1)
    println("After drop(1):")
    println("list: $list")   // list: Hans->Per->Ib->Nil
    println("list3: $list3") // list3: Per->Ib->Nil
    println()

    val list8 = PList("Pia").cons("Ulla").cons("Lene")
    val list9 = list8.reverse()
    println("After reverse():")
    println("list8: $list8") // list8: Lene->Ulla->Pia->Nil
    println("list9: $list9") // list9: Pia->Ulla->Lene->Nil
    println()

    val list14 = PList(6).cons(8).cons(2)
    val total = list14.fold(0) { acc, number -> acc + number }
    println("After fold():")
    println("list14: $list14") // list14: 2->8->6->Nil
    println("total: $total")   // total: 16
    println()
}
