package ru.startandroid.mybudget.pastexpense

import android.animation.AnimatorSet
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.startandroid.mybudget.ItemsViewModel
import ru.startandroid.mybudget.R
import ru.startandroid.mybudget.adapter.CustomAdapter
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

        val data = ArrayList<ItemsViewModel>()
        binding.rvPastExpense.layoutManager = LinearLayoutManager(context)

        for (i in 1..20) {
            data.add(ItemsViewModel("Non", "20,000 $i"))
        }
        val adapter = CustomAdapter(data)
        binding.rvPastExpense.adapter = adapter

        binding.btnNextFutExpInc.setOnClickListener() {
            findNavController().navigate(R.id.futureExpIncFragment, null, navOptions)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}