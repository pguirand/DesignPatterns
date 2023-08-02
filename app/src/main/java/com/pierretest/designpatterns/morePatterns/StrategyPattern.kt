package com.pierretest.designpatterns.morePatterns

// Strategy: PaymentStrategy
interface PaymentStrategy {
    fun calculatePaymentAmount(amount: Double): Double
}

// ConcreteStrategy: CreditCardPayment
class CreditCardPayment : PaymentStrategy {
    override fun calculatePaymentAmount(amount: Double): Double {
        // Assuming credit card payment has a 2% processing fee
        return amount + (amount * 0.02)
    }
}

// ConcreteStrategy: PayPalPayment
class PayPalPayment : PaymentStrategy {
    override fun calculatePaymentAmount(amount: Double): Double {
        // Assuming PayPal payment has a fixed transaction fee of $1.50
        return amount + 1.50
    }
}

// Context: PaymentProcessor
class PaymentProcessor(private val paymentStrategy: PaymentStrategy) {
    fun processPayment(amount: Double) {
        val paymentAmount = paymentStrategy.calculatePaymentAmount(amount)
        println("Payment amount: $paymentAmount")
    }
}

fun main() {
    val creditCardPayment = CreditCardPayment()
    val payPalPayment = PayPalPayment()

    val creditCardPaymentProcessor = PaymentProcessor(creditCardPayment)
    creditCardPaymentProcessor.processPayment(100.0) // Output: Payment amount: 102.0

    val payPalPaymentProcessor = PaymentProcessor(payPalPayment)
    payPalPaymentProcessor.processPayment(100.0) // Output: Payment amount: 101.5
}


/*

In this example, we create two payment strategies: creditCardPayment and payPalPayment,
and use them with the PaymentProcessor to calculate the payment amount for different
payment methods. By changing the strategy passed to the PaymentProcessor,
we can easily switch between different payment calculation algorithms at runtime.

The Strategy Pattern promotes better code organization, as each payment strategy
is encapsulated in its own class, making it easy to add new strategies or modify
existing ones without affecting the client code. It also enables the client to
choose the appropriate strategy based on runtime conditions or user preferences.

*/
