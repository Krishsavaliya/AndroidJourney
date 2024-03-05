package dl.thismatters.bnakaccountprogram

class BankAccount(var accountHolder:String, var balance:Double) {

    private val transactionHistory = mutableListOf<String>()

    fun deposite(amount: Double){
        balance += amount
        transactionHistory.add("$accountHolder deposited $$amount")
    }
    fun withdrow(amount: Double){
        if (amount<=balance){
            balance -= amount
            transactionHistory.add("$accountHolder withdrawed $$amount")
        }else{
            println("You don't have sufficient funds to withdraw $$amount")
        }
    }
    fun displayTransactionHistory(){
        println("Transaction History of $accountHolder:")
        for (transaction in transactionHistory){
            println(transaction)
        }
    }

    fun accBalance(){
        println("$accountHolder's Balance is $balance")
    }

}