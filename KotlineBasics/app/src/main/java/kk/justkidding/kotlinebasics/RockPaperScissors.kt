package kk.justkidding.kotlinebasics

fun main(){

    var computerChoice = ""
    var playerChoice = ""
    println("Rock,Paper or Scissors? Enter your choice!")
    playerChoice = readln().lowercase()
    while (playerChoice != "rock" && playerChoice != "paper" && playerChoice != "scissors"){
        println("Try again")
        playerChoice = readln()
    }

    val randomnum = (1..3).random()
    when(randomnum){
        1 ->{computerChoice = "rock"}
        2 ->{computerChoice = "paper"}
        3 ->{computerChoice = "scissors"}
    }
    println(computerChoice)

    val winner = when{
        playerChoice == computerChoice -> "Tie"
        playerChoice == "rock" && computerChoice == "scissors" -> "Player"
        playerChoice == "paper" && computerChoice == "rock" -> "Player"
        playerChoice == "scissors" && computerChoice == "paper" -> "Player"
        else -> "Computer"
    }

    if (winner == "Tie"){
        println("It's a tie, play again!")
    }else{
        println("$winner won!")
    }

}