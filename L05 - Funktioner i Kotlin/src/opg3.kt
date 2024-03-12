import kotlin.random.Random
import kotlin.random.nextInt

/* Opgave 3
Create a data class Person with properties name: String and age: Int.
Program a function findFirst(), that has 2 parameters: a list of persons, and a function with a
person as parameter and Boolean as return type. The function findFirst() must return the first
person in the list that satisfies the function given as parameter.
Use the function as shown here:
val p30 = findFirst(persons) { it.getAge() < 30 }
a) Find the first person in the persons list with an age of 44.
b) Find the first person in the persons list with a name starting with 'S'.
c) Find the first person in the persons list with a name containing more than one ’i’.
d) Find the first person in the persons list with an age equal to the length of the name.
Program a function findAll(), similar to the function findFirst(). The findAll() method must
return a list of persons satisfying the function given as parameter
Use the findAll() method with a lambda expression to solve question f-i.
f) Find all persons with name containing the letter 'i'.
g) Find all persons with name starting with 'S'.
h) Find all persons with name of length 5.
i) Find all persons with name of length at least 6 and age below 40.
Make a generic funktion named findAllGen() that is an extension function on List<T>. Test
the function on a List<Person> and a List<Int>. */

data class Person (val name: String, val age: Int) {
    companion object {
        fun generateXob(): Person {
            val seed = Random.nextInt(1..10)
            val xob: Char = 'a'+seed
            val name: String = xob + "obson"

            return Person(name, seed * 3 + Random.nextInt(0..50))
        }
    }
}

fun main() {
    val persons: MutableList<Person> = mutableListOf()
    for (i: Int in 1..10) {
        persons.add(Person.generateXob())
    }
        persons.add(Person("Jønke", 44))
        persons.add(Person("Slambert", 17))
        persons.add(Person("Sillivister", 11))

    println()
    println("LIST OF PERSONS: " + persons)

    val find44 = findFirst(persons,{it.age == 44})
    println("Any with age = 44?                    " + find44)

    val findStartsWithS = findFirst(persons, {it.name.startsWith("S")})
    println("Any who starts with \"S\"?              " + findStartsWithS)

    val findIafterI = findFirst(persons) { person ->
        val i = person.name.indexOf('i')
        person.name.substring(i + 1).contains('i')
    }
    println("Any with an i after an i?             " + findIafterI)

    val findNameAgeEquiLength = findFirst(persons, {person -> person.name.length == person.age})
    println("Any with a name as long as their age? " + findNameAgeEquiLength)


}
fun findFirst(list: List<Person>, matchPred: (Person) -> Boolean): Person? {
    for (person in list) {
        if (matchPred(person)) {
            return person
        }
    }
    return null
}

fun findAll(list: List<Person>, matchPred: (Person) -> Boolean): List<Person> {
    val matches: MutableList<Person> = mutableListOf()

    for (person in list) {
        if (matchPred(person)) {
            matches.add(person)
        }
    }

    return matches
}



