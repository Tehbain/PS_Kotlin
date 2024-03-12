package scopefunctions

data class Person(var name: String, var age: Int, var city: String) {
    fun incrementAge(): Int = age++
}

fun traditionel(): String {
    val person = Person("Alice", 20, "Amsterdam")
    println(person)
    person.name = "Betty"
    person.city = "London"
    person.incrementAge()
    println(person)
    return person.name
}

// inline fun <T, R> T.let(block: (T) -> R): R
// Function: block: (T) -> R
fun letUsed(): String =
    Person("Alice", 20, "Amsterdam").let { it ->
        println(it)
        it.name = "Betty"
        it.city = "London"
        it.incrementAge()
        println(it)
        it.name
    }

// inline fun <T, R> T.run(block: T.() -> R): R
// Extension function: block: T.() -> R
fun runUsed(): String =
    Person("Alice", 20, "Amsterdam").run {
        println(this)
        this.name = "Betty"
        this.city = "London"
        this.incrementAge()
        println(this)
        this.name
    }

// inline fun <T> T.apply(block: T.() -> Unit): T
// Extension function: block: T.() -> Unit
fun applyUsed(): Person =
    Person("Alice", 20, "Amsterdam").apply {
        println(this)
        this.name = "Betty"
        this.city = "London"
        this.incrementAge()
        println(this)
    }

// inline fun <T> T.also(block: (T) -> Unit): T
// Function: block: (T) -> Unit
fun alsoUsed(): Person =
    Person("Alice", 20, "Amsterdam").also { it ->
        println(it)
        it.name = "Betty"
        it.city = "London"
        it.incrementAge()
        println(it)
    }

//---------------------------------------------------------
// NOT extension functions

// inline fun <T, R> with(receiver: T, block: T.() -> R): R
// Extension function: block: (T) -> Unit
fun withUsed(): String =
    with(Person("Alice", 20, "Amsterdam")) {
        println(this)
        this.name = "Betty"
        this.city = "London"
        this.incrementAge()
        println(this)
        this.name
    }

// inline fun <R> run(block: () -> R): R
// Function: block: () -> R
fun runFunUsed(): String =
    run {
        val person = Person("Alice", 20, "Amsterdam")
        println(person)
        person.name = "Betty"
        person.city = "London"
        person.incrementAge()
        println(person)
        person.name
    }

fun main() {
    println("Traditionel:")
    println(traditionel())
    println()

    println("let():")
    println(letUsed())
    println()

    println("run():")
    println(runUsed())
    println()

    println("apply():")
    println(applyUsed().name)
    println()

    println("also():")
    println(alsoUsed().name)
    println()

    println("with(): (not extension fun)" )
    println(withUsed())
    println()

    println("run(): (not extension fun")
    println(runFunUsed())
    println()

}
