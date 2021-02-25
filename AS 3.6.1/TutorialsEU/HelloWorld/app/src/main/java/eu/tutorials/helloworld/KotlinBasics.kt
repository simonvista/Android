package eu.tutorials.helloworld

import java.lang.IllegalArgumentException
import kotlin.math.floor

// data class, no open, toString method already implemented
//data class User(val id:Long,var name:String)
//  Abstract class can't be instantiated
//  Members of abstract class are not abstract by default unless abstract key word is placed at leftmost
    /*abstract class Mammal(private val name:String,private val origin:String,private val weight:Double){
        abstract var maxSpeed:Double
    abstract fun run()
    abstract fun breath()
    fun mammalInfo(): Unit {
        println("Name: $name, origin: $origin, weight: $weight, maxSpeed: $maxSpeed")
    }
}
class Human(name: String, origin:String, weight:Double, override var maxSpeed: Double) : Mammal(name,origin,weight){
    override fun run() {
        println("Human is running")
    }

    override fun breath() {
        println("Human is breathing")
    }
}
class Elephant(name: String, origin: String, weight: Double, override var maxSpeed: Double):Mammal(name,origin,weight){
    override fun run() {
        println("Elephant is running")
    }

    override fun breath() {
        println("Elephant is breathing")
    }
}*/
//  Interface
/*interface Drivable{
    val maxSpeed:Double
    fun drive(): String
    fun brake(): Unit {
        println("Car is braking")
    }
}
open class Car(override val maxSpeed: Double, val name:String, val brand:String) : Drivable{
    open var range:Double=0.0
    fun extendRange(amount: Double): Unit {
        if(amount>0) this.range+=amount
    }
    open fun drive(distance: Double): Unit {
        println("Dived for $distance miles by fuel")
    }

//    override fun drive(): String ="Implement drive method of Drivable interface"
    override fun drive(): String{
        return "Implement drive method of Drivable interface"
    }
}
class ElectricCar(maxSpeed: Double,name: String, brand: String,batteryLife:Double) : Car(maxSpeed,name, brand) {
    var chargerType="Type1"
    override var range=batteryLife*6
    override fun drive(distance: Double) {
        println("Dived range of $distance miles by electricity")
    }
    override fun drive(): String {
        return "Implement drive method of Car class"
    }

    override fun brake() {
//        super.brake()
        println("Electric car is braking")
    }
}*/

// All kotlin classes are final, not inheritable by default
//  parent class, super class, base class
// Open -> make parent class inheritable
// open class Vehicle{}
//  sealed make Car class not inheritable
//sealed class Car : Vehicle(){
//  Sub class, child class, derived class
//open class Car : Vehicle() {}
//  Any Kotlin class has [Any] as super class
/*open class Car(val name:String,val brand:String){
    open var range:Double=0.0
    fun extendRange(amount: Double): Unit {
        if(amount>0) this.range+=amount
    }
    open fun drive(distance: Double): Unit {
        println("Dived for $distance miles by fuel")
    }
}
class ElectricCar(name: String, brand: String,batteryLife:Double) : Car(name, brand) {
    var chargerType="Type1"
    override var range=batteryLife*6
     override fun drive(distance: Double) {
        println("Dived range of $distance miles by electricity")
    }
    fun drive(): Unit {
        println("Dived for ${this.range} miles by electricity")
    }
}*/
//    Visibility modifier
/*open class Base(){
    var a = 1
    private var b = 2
    protected open val c = 3
    internal val d = 4
    protected fun e(){}
}
class Derived : Base(){
//    b is not visible. Others are visible.
    override val c=9    // c is protected
}*/
fun main() {

//    Unsafe cast operator: as
//    Safe cast operator: as?, returns null if cast isn't possible
/*    val s1:Any="Kotlin"
    val s2:String?=s1 as? String
    val s3:Int?=s1 as? Int
    println("${s2}, ${s3}")*/

//    Visibility modifiers
//    a module is a set of Kotlin files compiled together and is on top of packages.
//    Packages on the other hand, are folders that groups related classes.
//    public if no specified modifier or denote public
//    private is only accessible within the same class
//    internal ,Kotlin feature, is only accessible within the module when it is implemented
//    protected is only accessible within the same class and child class
//    open -> override in child class
/*    val base=Base()     // visible: a,d
    val derived=Derived()   //visible: a,d*/

//    Lambda expression: {x,y... -> ...}
/*    val sum={a:Int,b:Int->a+b}
//    val sum:(Int,Int)->Int = {a,b->a+b}
    println(sum(5,80))
    fun addTwo(a:Int,b:Int)=a+b
    println(addTwo(5,81))*/

//    ArrayList is dynamic
/*    val arrList=ArrayList<String>()
    arrList.add("One")
    arrList.add("Two")
    println(arrList)
    for(i in arrList) println(i)
    val l1:MutableList<String> = mutableListOf()
    l1.add("Three")
    l1.add("Four")
    println(l1)
    arrList.addAll(l1)
    println(arrList)
    val itr=arrList.iterator()
    while(itr.hasNext()) println(itr.next())
    println("The size of arrList is ${arrList.size}")
    println("The element at index of 1 is ${arrList.get(1)}")*/
/*    val stringList: List<String> = listOf("Frank","Jim","Duke","Peter")
    val mixedTypeList: List<Any> = listOf("Mike",12,12.05,true,12.01f)
    for (value in mixedTypeList){
        when(value){
            is Int -> println("Int")
            is String -> println("String length is ${value.length}")
            is Double -> println("Double floor is ${floor(value)}")
            is Boolean -> println("Boolean")
            is Float -> println("Float")
            else -> println("Unknown type")
        }
*//*        if(value is Int) println("Int")
        else if(value is String) println("String length is ${value.length}")
        else if(value is Double) println("Double floor is ${floor(value)}")
        else if (value is Boolean) println("Boolean")
        else if (value is Float) println("Float")
        else println("Unknown type")*//*
    }
//    Smart cast
    val obj1: Any ="I have a dream"
    if(obj1 !is String) println("Not a string")
    else println("String with length of ${obj1.length}")
//    Explicit(unsafe) casting by "as" keyword -> Can go wrong
//    Obj1 is String, as works
    val str1: String=obj1 as String
    println(str1)
    val obj2:Any=1332
//    Obj2 is not String, as goes wrong
//    val str2:String=obj2 as String
//    println(str2)
//    Explicit(safe) casting by "as?" keyword
    val obj3:Any=1234
    val str3:String?=obj3 as? String
    println(str3)*/
/*    val h1=Human("John","USA",76.00,12.00)
    h1.run()
    h1.breath()
    val e1=Elephant("Pal","india",5000.00,20.00)
    e1.run()
    e1.breath()*/
/*    var c1=Car(200.00,"A3","Audi")
    var e1=ElectricCar(250.00,"Model-3","Tesla",85.00)
    c1.drive()
    c1.brake()
    e1.drive()
    e1.brake()*/
/*    var c1=Car("A3","Audi")
    var e1=ElectricCar("Model-3","Tesla",85.0)
//    Polymophism -> Same name, different forms
    c1.drive(12.2)
    e1.drive()
    e1.drive(1200.00)*/
/*    val user1=User(1,"John")
    println("User info: ${user1}")
    user1.name="Jack"
    println("User info: ${user1}")
    val user2=User(1,"Jack")
    println(user1 == user2)
//    Copy data obj and update user name
    val user1Copy=user1.copy(name="Hellen")
    println(user1)
    println(user1Copy)
    println("${user1Copy.component1()}, ${user1Copy.component2()}")
//    Deconstruction
    val (id,name)=user1
    println("$id, $name")*/
//    Todo: Add new function
//  Var is mutable during runtime
//    Type inference finds type from context
   /* var name1="Mike"
    name1="Bob"*/
//  Val is immutable during runtime
//    val name2="Jenne"
//    println("Hi $name1 & $name2")
//    Byte(8 bits), Short(16 bits), Int(32 bits), Long(64 bits), Boolean
    /*val myByte:Byte=13
    val myShort:Short=125
    val myInt:Int=123_123_123
    val myLong:Long=39_812_309_487_120_300*/
//    Floating point # types: Float(32 bits), Double(64 bits)
    /*val myFloat:Float= 13.37F
    val myDouble:Double=3.14159265358979323846*/
//    Boolean
    /*var isSunny:Boolean=true
    isSunny=false*/
//    Char
    /*var myChar:Char='V'
    myChar='$'*/
//    String
//    var myString="Hello Kotlin"
//    println("Lenth: ${myString.length}")
//    Arithmatic operators(+,-,*,/,%)
    /*var res=3+4
    res/=2
    println(res)
    var res1:Double
    res1=5.0/3
    println(res1)*/
//    Comparison operator(>=,<=,==,!=)
    /*var isEqual=(3==3)
    println(isEqual)*/
//    String interpolation
//    println("Is -5<3?: ${-5<3}")
//    Assignment operators(+=,-=,/=,*=,%=)
//    Increment / decrement operator (++,--)
   /* var myNum=1
    println(myNum++)
    println(myNum)
    println(++myNum)
    println(myNum)*/
//    if{...}else if{...}else{...}
//    when statement
    /*val num=3
    when(num){
        1-> println("Spring")
        2->println("Summer")
        3->println("Autumn")
        4->println("Winter")
        else->println("Invalid input")
    }*/
    /*var month=2
    when(month){
        in 3..5-> println("Spring")
        in 6..8->println("Summer")
        in 9..11->println("Autumn")
        in 12 downTo 2->println("Wnter")
//        12,1,2->println("Wnter")
        else-> println("Invalid input")
    }*/
    /*val age=21
    when(age){
        !in 0..20->println("You can drink in US")
//        in 21..100-> println("You can drink in US")
        in 18..20->println("You can vote in US")
        16,17->println("You can drive in US")
        else-> println("Too young")
    }*/
    /*var x:Any=13.37f
    when(x){
        is Int-> print("Int")
        is Double-> println("Double")
        !is String-> println("Not string")
        else->println("None of above")
    }*/
//    while loop
    /*var x=10
    while(x>=0) {
        if (x % 2 == 0) {
            println(x)
        }
        x--
    }*/
//    do while loop
    /*var i=0
    do{
        println(i)
        i+=2
    }while(i<=10)*/
    /*var roomTemp=10
    while(true) {
        roomTemp++
        if (roomTemp == 20) break
    }
    println("It's finally cozy when roomTemp is $roomTemp")*/
//    for loop  0..10==0 until 10 (upper bound is exclusive)
    /*for(num in 0..10 step 2) println(num)
    for(i in 1 until 10 step 2) println(i)
    for(i in 1.until(10).step(2)) println(i)
    for(i in 10 downTo 0 step 2) println(i)
    for(i in 10.downTo(0).step(2)) println(i)*/
//    Function
    /*say("Mike")
    println(addTwo(3,6))*/
//    Null
//    var name:String?="Mike"
//    name=null
    /*if(name!=null){
        println(name.length)
    }else{
        println("-1")
    }*/
    /*val len=if(name!=null) name.length else -1
    println(len)*/
//    Safety operator
    /*val len=name?.length
    println(len)*/
//    name?.let { println(name.length) }
//    Elvis operator ?: default
    /*var name:String?="Mike"
    name=null
    val name1=name ?: "Default Name"
    println(name1)*/
//    Double-bang operator throws NullPoniterException if value is null
//    name!!.toLowerCase()
//    Safe chain check
//    val wifeAge:Int?=Family?.wife?.age? : 0
    /*var p1=Person("Mike","Yahoo")
    p1.sayHobby()
    p1.hobby="Chessboard"
    p1.sayHobby()
    p1.age=33
    println("${p1.age}")*/
   /* var p1=Person("John","Doe",35)
    p1.sayHobby()*/
//    p1=Person()
//    f1(3)
/*    var c1=Car()
    println(c1.owner)
    println(c1.brand)
    c1.maxSpeed=300
    println(c1.maxSpeed)
    c1.maxSpeed=-1
    println(c1.maxSpeed)*/
//    Private setter
//    c1.model="Jaguart"

}

/*
fun say(name:String): Unit {
    println("Hello $name")
}
fun addTwo(x: Int, y: Int): Int {
    return x+y
}*/
//  Class with 1st constructor
/*class Person(firstName:String="Amy",lastName:String="Wong"){
//    Member variable | properties
    var age:Int?=null
    var hobby:String="Reading"
    var firstName:String?=null
    var lastName:String?=null
//    Creating Person obj will trigger init automatically
    init {
        this.firstName=firstName
        this.lastName=lastName
        println("Person ($firstName, $lastName) was created")
    }
//    Member constructor: 2nd
    constructor(firstName:String="Amy",lastName:String="Wong",age:Int) : this(firstName,lastName){
        this.age=age
        println("Person ($firstName, $lastName, $age) was created")
    }

    //    Member function | method
    fun sayHobby(): Unit {
        println("$firstName, $lastName like $hobby")
    }
}*/
//  Function scope. Can't access outside of function
/*fun f1(a:Int){
//    a is variable which overrides parameter a -> don't do it!
    var a=5
    println("$a")
    println(a)
    var b=a
}*/
//  lateinit. Be carefull to use it if forget to initialize.
/*class Car(){
    lateinit var owner:String
    //    field-1
    val brand:String="BMW"
//   Custom getter
        get() {
            return field.toLowerCase()
        }
//    field-2
    var maxSpeed:Int=200
//        Default getter and setter
        *//*get() = field
        set(value) {
            field=value
        }*//*
//    Override setter
//        set(value) {
//            field=if(value>250) 250 else value
//        }
            set(value) {
                field=if(value>0) value else throw IllegalArgumentException("Negative speed error!")
            }
    var model:String="MS"
//    private setter
        private set
    init{
        this.owner="Frank"
//        Private setter
        this.model="M3"
    }
}*/
