package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("onCreate", "Main called")

        //refer to view
        //input
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)

        //output
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)

        //interaction
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {

            if(editTextHeight.text.isEmpty()){
                editTextHeight.setError("Value required")
                return@setOnClickListener
            }

            if(editTextWeight.text.isEmpty()){
                editTextWeight.setError("Value required")
                return@setOnClickListener
            }

            val weight = editTextWeight.text.toString().toDouble()
            val height = editTextHeight.text.toString().toDouble()
            val bmi = weight/(height/100).pow(2)

            // <18.5 = underWeight, 18.5 - 24.9 = normal, >24.9 = overWeight
            if(bmi < 18.5){  //underweight
                //textViewBMI.text = bmi.toString()
                textViewBMI.text = String.format("%.2f", bmi)
                textViewStatus.text = getString(R.string.under)
                //textViewStatus.text = getString(R.string.under)
                imageViewBMI.setImageResource(R.drawable.under)
            } else if(bmi in 18.5..24.9){
                textViewBMI.text = bmi.toString()
                textViewStatus.text = getString(R.string.normal)
                //textViewStatus.text = getString(R.string.normal)
                imageViewBMI.setImageResource(R.drawable.normal)
            } else{
                textViewBMI.text = bmi.toString()
                textViewStatus.text = getString(R.string.over)
                //textViewStatus.text = getString(R.string.over)
                imageViewBMI.setImageResource(R.drawable.over)
            }


        }

        buttonReset.setOnClickListener {
            editTextHeight.text.clear()
            editTextWeight.text.clear()
            //editTextWeight.setText("")
            //textViewMessage.text = ""
            textViewBMI.text = ""
            textViewStatus.text = ""
            imageViewBMI.setImageResource(R.drawable.empty)
            editTextWeight.requestFocus()
        }

        val imageViewInfo = findViewById<ImageView>(R.id.imageViewInfo)
        imageViewInfo.setOnClickListener{
            //Explicit Intent
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d("onsStart", "onStart called")
    }
}