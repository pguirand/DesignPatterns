package com.pierretest.designpatterns.SOLID


interface Shape {
    fun calculateArea(): Double
}

class Rectangle(private val length: Double, private val width: Double) : Shape {
    override fun calculateArea(): Double {
        return length * width
    }
}

class Circle(private val radius: Double) : Shape {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class ShapeAreaCalculator {
    fun getTotalArea(shapes: List<Shape>): Double {
        var totalArea = 0.0
        for (shape in shapes) {
            totalArea += shape.calculateArea()
        }
        return totalArea
    }
}

class Triangle(private val base: Double, private val height: Double) : Shape {
    override fun calculateArea(): Double {
        return 0.5 * base * height
    }
}

/*This follows the "open for extension, close for modification" principle.
The ShapeAreaCalculator class is closed for modification because
you don't need to change it to add new shapes in the future. Instead,
you can introduce new shapes by extending the Shape interface and
creating new classes (Triangle) that implement it, without altering the
existing ShapeAreaCalculator class.*/



fun main() {
    val shapes = listOf(
        Rectangle(5.0, 3.0),
        Circle(2.5),
        Triangle(4.0, 6.0)
    )

    val calculator = ShapeAreaCalculator()
    val totalArea = calculator.getTotalArea(shapes)
    println("Total area: $totalArea")
}
