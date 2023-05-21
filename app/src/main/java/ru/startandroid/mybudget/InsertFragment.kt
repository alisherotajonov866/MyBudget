package ru.startandroid.mybudget

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.startandroid.mybudget.adapter.ProductAdapter
import ru.startandroid.mybudget.databinding.FragmentInsertBinding
import ru.startandroid.mybudget.myDB.DBHelper
import ru.startandroid.mybudget.pastexpense.PastExpenseFragment

class InsertFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: FragmentInsertBinding? = null
    private val binding get() = _binding!!

    private lateinit var listProduct: ArrayList<Product>

    private val productAdapter by lazy {
        ProductAdapter(listProduct)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInsertBinding.inflate(layoutInflater, container, false)

        val db = DBHelper(requireContext(),null)

        binding.apply {
            btnSave.setOnClickListener(){
                val name = binding.etName.text.toString()
                val price = binding.etPrice.text.toString().toDouble()
                val product = Product(Name = name, Price = price)
                db.addProduct(product)
                Toast.makeText(context,"Add product",Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}