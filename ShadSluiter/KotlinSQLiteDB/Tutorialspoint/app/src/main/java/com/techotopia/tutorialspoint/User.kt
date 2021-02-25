package com.techotopia.tutorialspoint

class User {
    var id:Int=0
    var name:String=""
    var age:Int=0
    constructor(id:Int,name:String,age:Int){
        this.id=id
        this.name=name
        this.age=age
    }
    constructor(name:String,age:Int){
        this.name=name
        this.age=age
    }

    constructor()

    override fun toString(): String {
        return "$id, $name, $age"
    }
//    Getter, setter, toString auto provided
}