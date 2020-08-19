package com.ytlabs.filereader

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    private val FILE_NAME = "myFile.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {

        buttonRead.setOnClickListener {
            val file = File(filesDir, FILE_NAME)
            val textInFile = file.readText()
            textViewFile.text = textInFile
        }

        buttonSave.setOnClickListener {
            val text = editTextPersonName.text.toString()
            val fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
            fileOutputStream.write(text.toByteArray())
        }

    }

}