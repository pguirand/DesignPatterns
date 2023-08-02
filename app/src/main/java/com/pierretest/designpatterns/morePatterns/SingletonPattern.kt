package com.pierretest.designpatterns.morePatterns

object MySingleton {
    init {
        // Initialization code (optional)
        println("Singleton instance is created.")
    }

    fun doSomething() {
        println("Doing something...")
    }
}

fun main() {
    // Accessing the singleton instance
    MySingleton.doSomething()
    MySingleton.doSomething()

    //the same object is the one being called in the two cases

}
