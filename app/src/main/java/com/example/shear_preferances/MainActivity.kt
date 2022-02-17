package com.example.shear_preferances

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

     var infotv:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameEt =findViewById<EditText>(R.id.nameEt)
        var ageEt =findViewById<EditText>(R.id.ageEt)
        var switchh =findViewById<Switch>(R.id.switchh)

        infotv=findViewById(R.id.infotv)

        val sharedPreferences = getSharedPreferences("SP_INFO",Context.MODE_PRIVATE)

        var savebtn =findViewById<Button>(R.id.savebtn)
        savebtn.setOnClickListener {

            var name = nameEt.text.toString().trim()
            var age = Integer.parseInt(ageEt.text.toString().trim())
            var experience = switchh.isChecked

            val editor = sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putInt("AGE",age)
            editor.putBoolean("EXPERIRENCE",experience)
            editor.apply()
            Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT).show()
        }
        var showbtn =findViewById<Button>(R.id.showbtn)
        showbtn.setOnClickListener {
            val name = sharedPreferences.getString("NAME","")
            val age = sharedPreferences.getInt("AGE", 0)
            infotv?.text = "Name: $name\nAge: $age"
        }
    }
}