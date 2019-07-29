package com.antonius1998gmail.wrkshp13

import android.database.Cursor
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class ListActivity : AppCompatActivity() {
    var TAG :String ="List Data Activity"

    lateinit var mListView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        mListView = findViewById(R.id.listView)
        populateListView()
    }

    fun populateListView(){

        Log.d(TAG,"PopulateListView: Display data in the Listview")
        val mDatabaseHelper = DatabaseHelper(this)
        val data  :Cursor= mDatabaseHelper.data
        val listData = ArrayList<String>()
        while (data.moveToNext()){
            listData.add(data.getString(1))
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listData)
        mListView.adapter = adapter
    }
}