package com.rezaei.ischool.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.rezaei.ischool.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.google.firebase.storage.ktx.component1

class DownloadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        val storage = Firebase.storage
        val storageRef = storage.reference
        showListOfBooks(storageRef)

        val mainPageBtn = findViewById<Button>(R.id.mainScreenBtn)
        mainPageBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    fun showListOfBooks(storageRef: StorageReference) {
        val pdfs: StorageReference? = storageRef.child("PDF")
        println("___***____")
        pdfs?.listAll()?.addOnSuccessListener { (items) ->
            println(items)
        }
        if (pdfs != null) {
            println(pdfs.listAll())
        }
    }



}