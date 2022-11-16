package com.example.fibonaccifunc.function

class PrimeNumber(var userInput: Int) {
    private val lstPrimeNumber = arrayListOf<Int>()

    fun generatePrimeNumber(): ArrayList<Int>? {
        val lstCheckPrime = arrayListOf<Int>()

        if (userInput<2){
            return null
        }else {
            for (i in 2..userInput) {
                lstCheckPrime.clear()
                for (j in 2..i) {
                    if (i % j == 0) {
                        lstCheckPrime.add(j)
                    }
                }
                if (lstCheckPrime.size==1) lstPrimeNumber.add(i)
            }
        }
        return lstPrimeNumber
    }
}