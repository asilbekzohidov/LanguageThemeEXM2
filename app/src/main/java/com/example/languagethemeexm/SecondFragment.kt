package com.example.languagethemeexm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.examplelanguagetheme.utils.SharedPref
import com.example.languagethemeexm.databinding.FragmentFirstBinding
import com.example.languagethemeexm.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding?.lightBtn?.setOnClickListener {
            SharedPref.changTheme(requireContext(), "light")
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            val intent = Intent(requireActivity(), MainActivity::class.java)
            requireActivity().finish()
            startActivity(intent)
        }

        binding?.nightBtn?.setOnClickListener {
            SharedPref.changTheme(requireContext(), "night")
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            val intent = Intent(requireActivity(), MainActivity::class.java)
            requireActivity().finish()
            startActivity(intent)
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonSecond?.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}