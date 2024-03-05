package kk.justkidding.kotlinebasics

fun main(){

    var shoppingList = mutableListOf("Processor","GPU","MotherBoard","Mouse",
        "Keyboard","CoolingSystem","RAM","SSD","Moniter","CPU Case","PowerSupply","OVA")

    shoppingList.add("Something 1")
    shoppingList.add("Something 2")
    shoppingList.add("Something 3")

//    println(shoppingList)
    shoppingList.removeAt(12)
    shoppingList.removeAt(12)
    shoppingList.removeAt(12)
    shoppingList.contains("something")
//    shoppingList.shuffle()

    shoppingList[0]= "Ryzen 7 5600H"
    println(shoppingList)













    /*
//    Here object of class Animal is created
    var Dog = Animal("Moti","Dog")
    println("${Dog.name} is a ${Dog.Type} and is ${Dog.age} year's old!")

//    This two are objects of class Book
    var myBook = Book()
    println("${myBook.title} is book by ${myBook.author} published in year ${myBook.yearPublished}")
    var customBook = Book("PsychologyofMoney","MorganHousel",2020)
    customBook.yearPublished = 2022
    println("${customBook.title} is book by ${customBook.author} published in year ${customBook.yearPublished}")
*/
}
