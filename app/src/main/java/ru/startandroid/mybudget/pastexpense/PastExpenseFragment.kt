package ru.startandroid.mybudget.pastexpense

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.startandroid.mybudget.Product
import ru.startandroid.mybudget.R
import ru.startandroid.mybudget.adapter.ProductAdapter
import ru.startandroid.mybudget.databinding.FragmentPastExpenseBinding
import ru.startandroid.mybudget.myDB.DBHelper

class PastExpenseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentPastExpenseBinding? = null
    private val binding get() = _binding!!

    lateinit var listProduct: ArrayList<Product>
    private val productAdapter by lazy {
        ProductAdapter(listProduct)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val db = DBHelper(requireContext(),null)
        listProduct = ArrayList(db.listProduct())

        _binding = FragmentPastExpenseBinding.inflate(layoutInflater, container, false)
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.enter)
            .setExitAnim(R.anim.exit)
            .setPopEnterAnim(R.anim.pop_enter)
            .setPopExitAnim(R.anim.pop_exit)
            .build()

        binding.rvPastExpense.layoutManager = LinearLayoutManager(context)
        binding.rvPastExpense.adapter = productAdapter

        binding.btnNextFutExpInc.setOnClickListener() {
            findNavController().navigate(R.id.futureExpIncFragment, null, navOptions)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = DBHelper(requireContext(),null)
        listProduct = ArrayList(db.listProduct())
        val productAdapter = ProductAdapter(listProduct)
        binding.rvPastExpense.layoutManager = LinearLayoutManager(context)
        binding.rvPastExpense.adapter = productAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}