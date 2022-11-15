package com.example.fibonaccifunc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fibonaccifunc.databinding.FragmentMainBinding
import com.example.fibonaccifunc.function.Fibonacci

class FragmentMain : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    var userInput: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    private fun init() {
        binding.btnFindMember.setOnClickListener {
            if (binding.ediTextUserInput.text.isNullOrEmpty()) {
                binding.txtShowAnswer.text = ""
                Toast.makeText(context, "Please Input NUMBER before proceed", Toast.LENGTH_SHORT).show()
            } else {
                userInput = Integer.parseInt(binding.ediTextUserInput.text.toString())
                val fibonacci = Fibonacci(userInput?:0)
                fibonacci.findFibonacciMember()
                binding.txtShowAnswer.text = fibonacci.getListOfMember().toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

