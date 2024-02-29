package com.aftarfadilah.anmp_w2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.aftarfadilah.anmp_w2.databinding.FragmentMainBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var num1: Int = 0
    private var num2: Int = 0
    public var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(
            inflater,
            container, false
        )
        return binding.root
//        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun generateRandomNumbers() {
        num1 = Random.nextInt(101) // Random number between 0 and 100
        num2 = Random.nextInt(101) // Random number between 0 and 100
    }

    private fun displayQuestion() {
        binding.txtMathQuestion.text = "${num1} + ${num2}"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val playerName =
                MainFragmentArgs.fromBundle(requireArguments()).playerName
            binding.playersTurn.text = "$playerName's Turn"
        }

        generateRandomNumbers();
        displayQuestion();

        binding.btnSubmit.setOnClickListener {
            val userAnswer = binding.editTextAnswer.text.toString()
            if(userAnswer == (num1 + num2).toString()) {
                score += 1;
                generateRandomNumbers();
                displayQuestion();
            } else {
                val action = MainFragmentDirections.actionGameOver(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}