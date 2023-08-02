package com.pierretest.designpatterns.morePatterns

// Product: Pizza
data class Pizza(
    val crustType: String,
    val sauceType: String,
    val cheeseType: String,
    val toppings: List<String>
)

// Builder: PizzaBuilder
interface PizzaBuilder {
    fun setCrustType(crustType: String): PizzaBuilder
    fun setSauceType(sauceType: String): PizzaBuilder
    fun setCheeseType(cheeseType: String): PizzaBuilder
    fun setToppings(toppings: List<String>): PizzaBuilder
    fun build(): Pizza
}

// ConcreteBuilder: MargheritaPizzaBuilder
class MargheritaPizzaBuilder : PizzaBuilder {
    private var crustType: String = ""
    private var sauceType: String = ""
    private var cheeseType: String = ""
    private var toppings: List<String> = listOf()

    override fun setCrustType(crustType: String): PizzaBuilder {
        this.crustType = crustType
        return this
    }

    override fun setSauceType(sauceType: String): PizzaBuilder {
        this.sauceType = sauceType
        return this
    }

    override fun setCheeseType(cheeseType: String): PizzaBuilder {
        this.cheeseType = cheeseType
        return this
    }

    override fun setToppings(toppings: List<String>): PizzaBuilder {
        this.toppings = toppings
        return this
    }

    override fun build(): Pizza {
        return Pizza(crustType, sauceType, cheeseType, toppings)
    }
}

// Director: PizzaDirector
class PizzaDirector(private val pizzaBuilder: PizzaBuilder) {
    fun buildMargheritaPizza(): Pizza {
        return pizzaBuilder
            .setCrustType("Thin crust")
            .setSauceType("Tomato")
            .setCheeseType("Mozzarella")
            .setToppings(listOf("Basil", "Tomatoes"))
            .build()
    }
}

fun main() {
    val margheritaPizzaBuilder = MargheritaPizzaBuilder()
    val pizzaDirector = PizzaDirector(margheritaPizzaBuilder)
    val margheritaPizza = pizzaDirector.buildMargheritaPizza()

    println("Margherita Pizza:")
    println("Crust: ${margheritaPizza.crustType}")
    println("Sauce: ${margheritaPizza.sauceType}")
    println("Cheese: ${margheritaPizza.cheeseType}")
    println("Toppings: ${margheritaPizza.toppings.joinToString(", ")}")
}

/*

In this example, we have a Pizza data class that represents the complex object being constructed.
The PizzaBuilder interface declares methods for setting the properties of the Pizza class,
and the MargheritaPizzaBuilder is a concrete implementation of the PizzaBuilder.

The PizzaDirector class controls the construction process using the PizzaBuilder to create a Pizza
with specific configurations. The buildMargheritaPizza() method demonstrates how we can build a
Margherita pizza with the desired properties.


By using the Builder Pattern, we can construct complex objects with various configurations in a more
readable and maintainable way. The Builder Pattern is especially beneficial when the number
of optional parameters or configurations for an object is large, making it hard to use constructors
with multiple arguments. It provides a clear and structured way to create objects while keeping
the construction process separated from the object's representation

*/
