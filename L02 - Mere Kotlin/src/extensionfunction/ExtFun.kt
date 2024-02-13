package extensionfunction

import java.lang.StringBuilder

fun String.titleCase(): String {
    if (this.isEmpty()) return this
    val sb = StringBuilder()
    sb.append(this[0].uppercase())
    for (i in 1..this.lastIndex) {
        if(this[i-1] ==' ') {
            sb.append(this[i].uppercase())
        } else {
            sb.append(this[i])
        }
    }
    return sb.toString()
}

class Circle (val radius: Double){
    // member function in Circle class
    fun area(): Double{
        return Math.PI * radius * radius;
    }
}

// Extension function created for a class Circle
fun Circle.perimeter(): Double {
    return 2 * Math.PI * radius;
}

fun main(){
    // invoke extension function on String
    println("this is a long title".titleCase())
    println()

    val circle = Circle(2.5)
    // invoke member function
    println("Area of the circle is ${circle.area()}")
    // invoke extension function
    println("Perimeter of the circle is ${circle.perimeter()}")
}
