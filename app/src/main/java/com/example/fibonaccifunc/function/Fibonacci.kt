package com.example.fibonaccifunc.function

class Fibonacci(var userInput: Int) {
    private val memberOfFibonacci = if (userInput ==0) arrayListOf(0)
    else arrayListOf(0,1)

    fun findFibonacciMember() {
       var sum = 0
        for (i in 0..userInput){
            if (sum <= userInput){
                val j = memberOfFibonacci[i+1]
                sum = memberOfFibonacci[i] + j
            }
            if (sum<=userInput) memberOfFibonacci.add(sum)
        }
    }

    fun getListOfMember():ArrayList<Int>{
        return memberOfFibonacci
    }
}