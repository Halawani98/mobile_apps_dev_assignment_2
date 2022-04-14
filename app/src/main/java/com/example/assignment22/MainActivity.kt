package com.example.assignment22

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val name: EditText = findViewById(R.id.EditText)
        val age: EditText = findViewById(R.id.EditText2)
        val male: RadioButton = findViewById(R.id.radioButton1)
        var gender = ""
        val reciver: TextView = findViewById(R.id.textView4)
        val spinner: Spinner = findViewById(R.id.spinner)




        val Colors = arrayOf(
            "Text Color",
            "Red",
            "Blue",
            "Yellow"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            Colors
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter;


        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()

                when (selectedItem) {

                    Colors[0] ->
                        reciver.setTextColor(Color.BLACK)

                    Colors[1] -> {
                        reciver.setTextColor(Color.RED)

                    }
                    Colors[2] -> {
                        reciver.setTextColor(Color.BLUE)

                    }
                    Colors[3] -> {
                        reciver.setTextColor(Color.YELLOW)

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        button.setOnClickListener{ view->
            if(male.isChecked)
                gender = "Male"
            else gender = "Female"

            reciver.text = "\nName: " + name.text.toString() + "\nAge: " +  age.text.toString() + "\nGender: " + gender

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity : View = findViewById(R.id.MainActivity)
        val activity2 : View = findViewById(R.id.Activity2)

        when (item.itemId){
            R.id.white->{
                activity.setBackgroundColor(Color.WHITE)
                activity2.setBackgroundColor(Color.WHITE)}
            R.id.red->{
                activity.setBackgroundColor(Color.RED)
                activity2.setBackgroundColor(Color.RED)}
            R.id.blue->{
                activity.setBackgroundColor(Color.BLUE)
                activity2.setBackgroundColor(Color.BLUE)}
            R.id.about->{
                var dialog = About()
                dialog.show(supportFragmentManager, "RateDialog")
            }

        }

        return super.onOptionsItemSelected(item)
    }
}