package dl.thismatters.bnakaccountprogram

fun main(){

    var krishbankAccount = BankAccount("Krish",13003.67)

    krishbankAccount.deposite(400.00)
    krishbankAccount.deposite(324.32)
    krishbankAccount.deposite(15000.0)

    krishbankAccount.withdrow(1920.90)
    krishbankAccount.displayTransactionHistory()
    krishbankAccount.accBalance()

    var account102 = BankAccount("Sarah",0.0)
    account102.deposite(100.0)
    account102.withdrow(10.0)
    account102.deposite(300.0)
    account102.displayTransactionHistory()
    account102.accBalance()


}