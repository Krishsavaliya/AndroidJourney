package kk.justkidding.kotlinebasics

class Animal(val name: String,val Type: String,val age: Int=0) {

//This is initializer block which executed first when class is called!!
    init {
        bark()
    }

    fun bark(){
        println("Woof!, Woooof!!!!!!!!")
    }

}