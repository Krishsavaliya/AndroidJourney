package kk.justkidding.kotlinebasics

data class CoffeDetails(
    val name:String,
    var sugarCount:Int,
    val size:String,
    val creamAmount:Int
){
    fun printHello(){
        println("Hello!!!")
    }
}

fun main(){

    var coffeForKrish = CoffeDetails("Krish",5,"Large",0)
    makeCoffe(coffeForKrish)
//    println("Do you want Coffe?")
//    var askingCoffe = readln().lowercase()
//    if (askingCoffe == "yes"){
//        println("What's your name?")
//        var name = readln()
//        println("how many spoons of sugar?")
//        var sugarCount = readln().toInt()
//        makeCoffe(name,sugarCount)
//    }else{
//        println("Thank You have a nice day :)")
//    }
}

fun makeCoffe(coffeDetails: CoffeDetails){
    if (coffeDetails.sugarCount == 1){
        println("A ${coffeDetails.size} coffe with ${coffeDetails.sugarCount} spoon of sugar and ${coffeDetails.creamAmount} squirt's of cream for ${coffeDetails.name} !")
    }else if (coffeDetails.sugarCount == 0){
        println("A ${coffeDetails.size} coffe with no spoons of sugar and ${coffeDetails.creamAmount} squirt's of cream for ${coffeDetails.name} !")
    }else if (coffeDetails.sugarCount in 2..10){
        println("A ${coffeDetails.size} coffe with ${coffeDetails.sugarCount} spoon of sugar and ${coffeDetails.creamAmount} squirt's of cream for ${coffeDetails.name} !")
    }else{
        println("Too much Sugar in a Coffe! or maybe wrong spelling")
    }
}