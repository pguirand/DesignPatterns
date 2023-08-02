package com.pierretest.designpatterns.morePatterns

// AbstractClass: CaffeineBeverage
abstract class CaffeineBeverage {
    // Template method containing the algorithm's steps
    fun prepareBeverage() {
        boilWater()
        brew()
        pourInCup()
        addCondiments()
    }

    // Common steps (these methods are common to all subclasses)
    private fun boilWater() {
        println("Boiling water")
    }

    private fun pourInCup() {
        println("Pouring into cup")
    }

    // Abstract methods (these methods must be overridden by subclasses)
    abstract fun brew()
    abstract fun addCondiments()
}

// ConcreteClass: Coffee
class Coffee : CaffeineBeverage() {
    override fun brew() {
        println("Dripping coffee through filter")
    }

    override fun addCondiments() {
        println("Adding sugar and milk")
    }
}

// ConcreteClass: Tea
class Tea : CaffeineBeverage() {
    override fun brew() {
        println("Steeping the tea bag")
    }

    override fun addCondiments() {
        println("Adding lemon")
    }
}

/*

In this example, we have an CaffeineBeverage abstract class that defines
the prepareBeverage() method, which serves as the template method containing
the sequence of steps for preparing the beverage.
The common steps (boilWater() and pourInCup()) are implemented in the base class,
while the specific steps (brew() and addCondiments()) are left abstract.

The Coffee and Tea classes are concrete subclasses of CaffeineBeverage.
They provide their own implementations for the abstract methods
(brew() and addCondiments()).

*/

fun main() {
    val coffee = Coffee()
    val tea = Tea()

    println("Preparing coffee...")
    coffee.prepareBeverage()

    println("\nPreparing tea...")
    tea.prepareBeverage()
}

/*

In this example, when we call coffee.prepareBeverage() and tea.prepareBeverage(),
the template method defined in the CaffeineBeverage class executes the common
steps (boilWater() and pourInCup()) and then calls the abstract methods
(brew() and addCondiments()), which are overridden in the concrete subclasses
(Coffee and Tea) to provide their own specific implementations.

The Template Method Pattern allows us to define a high-level algorithm in a base
class while deferring the implementation of specific steps to subclasses.
This promotes code reuse and consistency across multiple classes that share
a common algorithm. It also allows for easy extension and modification of the
algorithm without changing its overall structure.

        */
