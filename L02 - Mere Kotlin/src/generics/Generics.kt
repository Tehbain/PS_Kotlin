package generics

class Box<T>(elem: T) {
    private var element: T = elem
    fun getT(): T = element
    fun setT(elem: T) {
        this.element = elem
    }
}

open class Dog(val name: String) {
    override fun toString(): String = "Dog $name"
}

open class Husky(name: String) : Dog(name) {
    override fun toString(): String = "Husky $name"
}

fun main() {
    var dogBox: Box<out Dog> = Box<Husky>(Husky("Husk"))
    var huskyBox: Box<in Husky> = Box<Dog>(Dog("Rex"))

//    val elem1  = dogBox.getT()
//    println(elem1)
//    dogBox.setT(Dog("Pax"))

//    val elem2 = huskyBox.getT()
//    println(elem2)
//    huskyBox.setT(Husky("Hu"))
//    val elem3 = huskyBox.getT()
//    println(elem3)
}
