package com.pierretest.designpatterns.morePatterns

// Prototype: Shape
interface PShape {
    fun clone(): PShape
}

// ConcretePrototype: Circle
data class PCircle(var radius: Double) : PShape {
    override fun clone(): PShape {
        return PCircle(radius) // Return a new Circle instance with the same radius
    }

    fun getInfo(): String {
        return "Circle with radius $radius"
    }
}

// ConcretePrototype: Rectangle
data class PRectangle(var width: Double, private val height: Double) : PShape {
    override fun clone(): PShape {
        return PRectangle(width, height) // Return a new Rectangle instance with the same width and height
    }

    fun getInfo(): String {
        return "Rectangle with width $width and height $height"
    }
}

fun main() {
    val originalCircle = PCircle(5.0)
    val clonedCircle = originalCircle.clone() as PCircle
    clonedCircle.radius = 8.0

    val originalRectangle = PRectangle(10.0, 6.0)
    val clonedRectangle = originalRectangle.clone() as PRectangle
    clonedRectangle.width = 12.0

    println("Original Circle: ${originalCircle.getInfo()}")
    println("Cloned Circle: ${clonedCircle.getInfo()}")

    println("Original Rectangle: ${originalRectangle.getInfo()}")
    println("Cloned Rectangle: ${clonedRectangle.getInfo()}")
}
/*

In this example, we create new shapes (clonedCircle and clonedRectangle)
by cloning existing shapes (originalCircle and originalRectangle).
The cloning process creates new instances with the same properties
as the original ones.

        */
