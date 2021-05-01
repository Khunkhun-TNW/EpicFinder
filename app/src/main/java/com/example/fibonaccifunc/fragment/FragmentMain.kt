package com.example.fibonaccifunc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fibonaccifunc.function.Fibonacci
import com.example.fibonaccifunc.databinding.FragmentMainBinding

class FragmentMain : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    var userInput: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }


    private fun init() {
        binding.btnFindMember.setOnClickListener(View.OnClickListener {
            userInput = Integer.parseInt(binding.ediTextUserInput.text.toString())
//            Toast.makeText(context, "$userInput", Toast.LENGTH_SHORT).show()
            if (userInput != null) {
                val fibonacci = Fibonacci(userInput, context)
                fibonacci.findFibonacciMember()
                binding.txtShowAnswer.text = fibonacci.getListOfMember().toString()
            } else if (userInput == null) {
                Toast.makeText(context, "Please Input NUMBER before proceed", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

