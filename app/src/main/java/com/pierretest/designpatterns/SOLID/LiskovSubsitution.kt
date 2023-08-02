package com.pierretest.designpatterns.SOLID

// Shape is a base class representing a geometric shape
open class AllShapes {
    open fun calculateArea(): Double {
        return 0.0
    }
}

// Rectangle is a subclass of Shape
class Rectangle2(private val length: Double, private val width: Double) : AllShapes() {
    override fun calculateArea(): Double {
        return length * width
    }
}

// Circle is another subclass of Shape
class Circle2(private val radius: Double) : AllShapes() {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}


/*

In the main function, we create instances of Rectangle and Circle
and pass them to the printArea function, which takes a Shape
parameter. Both Rectangle and Circle are subclasses of Shape
and we can use them interchangeably without affecting the
behavior of the printArea function. The correct area is
calculated and printed for each shape.
 */

fun printArea(shape: AllShapes) {
    println("Area: ${shape.calculateArea()}")
}

fun main() {
    val rectangle2 = Rectangle2(10.0, 4.5)
    val circle2 = Circle2(3.5)

    printArea(rectangle2)
    printArea(circle2)
}
