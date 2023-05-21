package ru.startandroid.mybudget.myDB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.startandroid.mybudget.DatabaseService
import ru.startandroid.mybudget.Product

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION), DatabaseService {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                PRICE_COL + " INTEGER" + ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    override fun addProduct(product: Product) {
        val values = ContentValues()
        values.put(NAME_COl, product.Name)
        values.put(PRICE_COL, product.Price)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    override fun listProduct(): List<Product> {
        val list = ArrayList<Product>()
        val db = this.readableDatabase
        val queary =  "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(queary,null)
        if (cursor.moveToFirst()){
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val price = cursor.getDouble(2)
                val product = Product(Name = name, Price = price)
                list.add(product)
            }while (cursor.moveToNext())
        }
        return list
    }

    override fun editProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun getProductCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getProductByID(id: Int): Product {
        TODO("Not yet implemented")
    }

    companion object {

        private const val DATABASE_NAME = "MyBudget"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "past_expenses"
        const val ID_COL = "id"
        const val NAME_COl = "name"
        const val PRICE_COL = "price"
    }
}
