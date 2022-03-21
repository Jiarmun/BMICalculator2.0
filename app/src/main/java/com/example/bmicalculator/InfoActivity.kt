package com.example.bmicalculator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.bmicalculator.databinding.ActivityInfoBinding

//to eliminate the use of findViewByID
//lateinit = late initialize
//var = variable
private lateinit var binding: ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    //private lateinit var  textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Associate view(s) to code
        binding = ActivityInfoBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_info)
        setContentView(binding.root)

        //textView = binding.textView10

        binding.buttonClose.setOnClickListener{
            finish() //close an Activity
            //binding.textView10.text = ""
        }

        binding.buttonFindOutMore.setOnClickListener {
            //binding.textView10.text = "Output"
            //Implicit Intent - to view a web page
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.euro.who.int/en/health-topics/disease-prevention/nutrition/a-healthy-lifestyle/body-mass-index-bmi"))
            //intent.data = Uri.parse("")
            startActivity(intent)
        }
    }
}