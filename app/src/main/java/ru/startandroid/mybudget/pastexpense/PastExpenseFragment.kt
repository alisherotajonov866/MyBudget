package ru.startandroid.mybudget.pastexpense

import android.animation.AnimatorSet
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import ru.startandroid.mybudget.R
import ru.startandroid.mybudget.databinding.FragmentPastExpenseBinding


class PastExpenseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentPastExpenseBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPastExpenseBinding.inflate(layoutInflater, container, false)

        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter)
            .setExitAnim(R.anim.exit)
            .setPopEnterAnim(R.anim.pop_enter)
            .setPopExitAnim(R.anim.pop_exit)
            .build()

        binding.btnNextFutExpInc.setOnClickListener() {
            findNavController().navigate(R.id.futureExpIncFragment, null, navOptions)
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