package com.pierretest.designpatterns.morePatterns

// Observer: WeatherObserver
interface WeatherObserver {
    fun update(temperature: Double, humidity: Double, pressure: Double)
}

// Subject: WeatherStation
class WeatherStation {
    private val observers: MutableList<WeatherObserver> = mutableListOf()
    private var temperature: Double = 0.0
    private var humidity: Double = 0.0
    private var pressure: Double = 0.0

    fun addObserver(observer: WeatherObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: WeatherObserver) {
        observers.remove(observer)
    }

    fun setWeatherData(temperature: Double, humidity: Double, pressure: Double) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        notifyObservers()
    }

    private fun notifyObservers() {
        for (observer in observers) {
            observer.update(temperature, humidity, pressure)
        }
    }
}

// ConcreteObserver: DisplayPanel
class DisplayPanel(private val location: String) : WeatherObserver {
    override fun update(temperature: Double, humidity: Double, pressure: Double) {
        println("Display Panel at $location: Temperature: $temperature, Humidity: $humidity, Pressure: $pressure")
    }
}

fun main() {
    val weatherStation = WeatherStation()
    val displayPanel1 = DisplayPanel("Living Room")
    val displayPanel2 = DisplayPanel("Kitchen")

    weatherStation.addObserver(displayPanel1)
    weatherStation.addObserver(displayPanel2)

    weatherStation.setWeatherData(25.0, 60.0, 1013.25)
}


/*

In this example, when we update the weather data using weatherStation.setWeatherData(),
both display panels (displayPanel1 and displayPanel2) are automatically notified and
updated with the new weather information.

The Observer Pattern enables decoupled communication between the subject and
its observers, making it easy to add or remove observers without affecting
other parts of the system. It promotes flexibility, maintainability, and
extensibility by allowing objects to react dynamically to changes in the state
of other objects.

*/
