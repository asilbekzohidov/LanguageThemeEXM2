package com.example.languagethemeexm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.languagethemeexm.databinding.FragmentFirstBinding
import com.example.languagethemeexm.utils.languageUpdate

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding?.ruBtn?.setOnClickListener {
            languageUpdate(requireActivity(), "ru")
            val intent = Intent(requireActivity(), MainActivity::class.java)
            requireActivity().finish()
            startActivity(intent)
        }

        binding?.uzBtn?.setOnClickListener {
            languageUpdate(requireActivity(), "uz")
            val intent = Intent(requireActivity(), MainActivity::class.java)
            requireActivity().finish()
            startActivity(intent)
        }

        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonFirst?.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}