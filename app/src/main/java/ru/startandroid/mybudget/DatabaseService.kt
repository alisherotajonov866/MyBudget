package ru.startandroid.mybudget

interface DatabaseService {
    fun addProduct(product: Product)
    fun listProduct(): List<Product>
    fun editProduct(product: Product)
    fun deleteProduct(product: Product)
    fun getProductCount(): Int
    fun getProductByID(id: Int): Product

}