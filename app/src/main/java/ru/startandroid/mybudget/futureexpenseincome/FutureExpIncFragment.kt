package ru.startandroid.mybudget.futureexpenseincome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.startandroid.mybudget.R
import ru.startandroid.mybudget.databinding.FragmentFutureExpIncBinding
import ru.startandroid.mybudget.databinding.FragmentPastExpenseBinding

class FutureExpIncFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: FragmentFutureExpIncBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFutureExpIncBinding.inflate(layoutInflater,container,false)
        binding.btnBackPastExp.setOnClickListener(){
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

    }
}