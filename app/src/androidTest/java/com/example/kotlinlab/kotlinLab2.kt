package com.example.kotlinlab


data class  Subject(val id: String, val name: String,val credit:Int)

open class Person(fName:String,lName:String,deptName:String){
    val firstName : String
    val lastName : String
    protected val department : String

    init {
        firstName = fName.capitalize()
        lastName = lName.capitalize()
        department = "$deptName, Faculty of Science"
    }

    open fun showDetail(){
        println("$firstName is at $department")
    }

    companion object{
        fun  showCompanion(first_Name:String,last_Name:String,age:Int){
            println("Person is called from companion object : $first_Name $last_Name is $age years old.")
        }
    }
}

class  Teacher(fName: String,lName: String,deptName: String,year:Int):Person(fName,lName,deptName){
    private var salary : Int = 0
    private val yearClass : Int = year
    private  var creditClass : Int =0

    override fun showDetail() {
        println("$firstName is a teacher for $yearClass years at $department")
    }

    fun calSalaly(){
        when{
            yearClass<5 ->salary = 25000 +(2000*yearClass)
            yearClass<10 -> salary = 36000 + (2000*(yearClass-5))
            yearClass<15 -> salary = 47000 + (2000*(yearClass-10))
            yearClass<20 -> salary = 58000 + (2000*(yearClass-15))
            else -> salary = 60000 + (2000*(yearClass-20))
        }
        println("$firstName's salary is $salary baht")
    }

    fun teach(subj : Subject){
        println(subj.toString())
        creditClass+=subj.credit
    }

    fun displayCredit(){
        println("$firstName teaches $creditClass credits.")
    }
}


object Singleton_Person{
    val first_Name="Carlos"
    val last_Name = "Silva"
    var age = 23

    fun showCompanion(){
        println("Person is called from singleton object : $first_Name $last_Name is $age years old.")
    }
}

fun main(){
    var person1 = Person("tony","green","computer Science")
    println("Member NO 1 : " +person1.firstName + " "+person1.lastName )
    person1.showDetail()
    println()

    println("Member NO 2 : ")
    Person.showCompanion("Bobby","Brow",25)
    println()

    var subject1 = Subject("342267","Mobile Device Programming",3)
    var subject2 = Subject("342233","Database Systems and Design",3)
    var subject3 = Subject("342233","Seminar in Information Technology",1)

    var person2 = Teacher("alice","tomato","Computer Science",25)
    println("Member NO 3 : "+person2.firstName+" "+person2.lastName)
    person2.showDetail()
    person2.calSalaly()
    println(person2.firstName+ " teaches : ")
    person2.teach(subject1)
    person2.teach(subject2)
    person2.teach(subject3)
    person2.displayCredit()
    println()

    println("Member NO 4 : ")
    Singleton_Person.showCompanion()
}