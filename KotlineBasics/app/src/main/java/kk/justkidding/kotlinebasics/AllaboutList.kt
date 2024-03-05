package kk.justkidding.kotlinebasics

fun main() {

    val numbers = mutableListOf(1,2,3,4,5)
    for (index in 0 until numbers.size){
        numbers[index]=numbers[index]*2
    }
    println(numbers)
//Created mutable List,there is also immutable list which is defined with 'listof()'
    var shoppingList = mutableListOf(
        "Processor", "GPU", "MotherBoard", "Mouse",
        "Keyboard", "CoolingSystem", "RAM", "SSD", "Moniter", "CPU Case", "PowerSupply", "OVA"
    )
//Some pr-defined methodes of List
    shoppingList.add("Something 1")
    shoppingList.add("Something 2")
    shoppingList.add("Something 3")

    println(shoppingList)
    shoppingList.removeAt(12)
    shoppingList.removeAt(12)
    shoppingList.removeAt(12)

    if (shoppingList.contains("something")){
        println("List Contains something")
    }else{
        println("List Doesn't Contain something")
    }
//    shoppingList.shuffle()

    shoppingList[0] = "Ryzen 7 5600H"
//This is same as above method
    shoppingList.set(1,"Geforce RTX 3050")

//For loop in kotlin is differrent from java, but it's easy
    for (i in shoppingList.size downTo 0 step 2){
        println(i)
    }
}