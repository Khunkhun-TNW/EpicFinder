package com.example.fibonaccifunc.fragment

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fibonaccifunc.R
import com.example.fibonaccifunc.databinding.FragmentFunctionalBinding
import com.example.fibonaccifunc.function.Fibonacci
import com.example.fibonaccifunc.function.PrimeNumber

class FragmentFunctional : Fragment() {
    private var _binding: FragmentFunctionalBinding? = null
    private val binding get() = _binding!!
    private var userInput: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFunctionalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val spinnerAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1, resources.getStringArray(R.array.spinnerView))
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnHeader.adapter = spinnerAdapter
        binding.spnHeader.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    0 ->{
                        binding.ediTextUserInput.hint = "Input a number (maximum 8 digit)"
                        binding.ediTextUserInput.filters = arrayOf(InputFilter.LengthFilter(8))
                        binding.outside.setBackgroundResource(R.color.purple_200)
                        binding.btnFindMember.setOnClickListener {
                            if (binding.ediTextUserInput.text.isNullOrEmpty()) {
                                responseEmptyText()
                            } else {
                                userInput = Integer.parseInt(binding.ediTextUserInput.text.toString())
                                val fibonacci = Fibonacci(userInput?:0)
                                fibonacci.findFibonacciMember()
                                binding.txtShowAnswer.text = fibonacci.getListOfMember().toString()
                            }
                        }
                    }

                    1 ->{
                        binding.ediTextUserInput.hint = "Input a number (maximum 5 digit)"
                        binding.ediTextUserInput.filters = arrayOf(InputFilter.LengthFilter(5))
                        binding.outside.setBackgroundResource(R.color.purple_500)
                        binding.btnFindMember.setOnClickListener {
                            if (binding.ediTextUserInput.text.isNullOrEmpty()) {
                                responseEmptyText()
                            } else {
                                userInput = Integer.parseInt(binding.ediTextUserInput.text.toString())
                                val primeNumber = PrimeNumber(userInput?:0)
                                binding.txtShowAnswer.text = primeNumber.generatePrimeNumber().toString()
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun responseEmptyText(){
        binding.txtShowAnswer.text = ""
        Toast.makeText(context, "Please Input NUMBER before proceed", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

