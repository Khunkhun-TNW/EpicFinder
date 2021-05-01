package com.example.fibonaccifunc.function

import android.content.Context
import android.widget.Toast

class Fibonacci(var userInput: Int?, private val context: Context?) {
    private val memberOfFibonacci = arrayListOf<Int>(0, 1)

    fun findFibonacciMember() {
        var j: Int = 0
         var sum: Int = 0
//        Toast.makeText(context, "$userInput", Toast.LENGTH_SHORT).show()
        for (i in 0..userInput!!) {
            if (sum <= userInput!!) {
                j = memberOfFibonacci[i + 1]
                sum = memberOfFibonacci[i] + j
                if (sum <= userInput!!) {
                    memberOfFibonacci.add(sum)
                }
                Toast.makeText(
                    context,
                    "i = ${memberOfFibonacci[i]} /// j = $j /// sum = $sum ///  Input = $userInput ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        for (i in memberOfFibonacci) {
            println(i)
        }
    }

    fun getListOfMember():ArrayList<Int>{
        return memberOfFibonacci
    }
}