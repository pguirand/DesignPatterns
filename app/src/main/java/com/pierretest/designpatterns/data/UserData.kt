package com.pierretest.designpatterns.data

data class UserData(
    var id: Long,
    var name:String,
    var password: String,
    var height:Double,
    var sex : String,
    var age : Int,
    var eyesColor: String

)

val user = UserData(height = 180.0, id=3121, eyesColor = "blue", name="Junior", password = "123456", sex = "Male", age = 22)



