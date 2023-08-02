package com.pierretest.designpatterns.SOLID

import com.pierretest.designpatterns.data.user

/*


For a simple object user the best practice is to separate each responsibility
or functionality on this user in different specific classes.
we could have a single class with the Authentication and Information's
functionality but it would now break the Single Responsibility Principle(SRP).
Each class has a specific responsibility. 1. Authenticate 2.UserInfo

*/

class AuthenticateUser() {

    init {
        println("** USER LOGIN **")
    }
    fun signIn() {
        println("Signing in the user : ${user.name}")
    }

    fun signOut() {
        println("Signing out the user : ${user.name}")
    }
}

class UserInfo {
    init {
        println("** USER INFO **")
    }
    fun ShowBasicInfos() {
        println("Name : ${user.name}\nAge: ${user.age}\nSex : ${user.sex}")
    }

    fun ShowBiometrics() {
        println("Eyes Color : ${user.eyesColor}\n" +
                "Height : ${user.height} cm")
    }
}



fun main() {
    val authUser = AuthenticateUser().signIn()
    val info = UserInfo().ShowBasicInfos()

    authUser
    info

}

