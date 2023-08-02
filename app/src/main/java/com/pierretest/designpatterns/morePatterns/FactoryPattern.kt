package com.pierretest.designpatterns.morePatterns

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Drawing a circle")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing a rectangle")
    }
}

// Abstract factory class
abstract class ShapeFactory {
    abstract fun createShape(): Shape
}

class CircleFactory : ShapeFactory() {
    override fun createShape(): Shape {
        return Circle()
    }
}

class RectangleFactory : ShapeFactory() {
    override fun createShape(): Shape {
        return Rectangle()
    }
}

fun main() {
    val shapeType = "circle" // This value can come from user input or configuration

    val shape: Shape = when (shapeType.toLowerCase()) {
        "circle" -> CircleFactory().createShape()
        "rectangle" -> RectangleFactory().createShape()
        else -> throw IllegalArgumentException("Unknown shape type")
    }

    shape.draw()
}

/*

In this example, based on the shapeType value, we create the appropriate
factory (either CircleFactory or RectangleFactory) and use the createShape()
method to obtain the shape object. We then call the draw() method on the
shape object, which prints the corresponding shape.

The Factory Method Pattern allows us to add new shapes in the future by creating
new subclasses of ShapeFactory and providing the implementation for the
createShape() method. This way, the client code does not need to be modified
when introducing new shapes, promoting flexibility and maintainability.

        */
