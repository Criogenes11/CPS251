package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalc.databinding.ActivityMainBinding
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(View.OnClickListener
        {
            calculateTip()
        })


    }
    fun calculateTip()
    {
        var stringInTextField =binding.billAmount.text.toString()
        var cost = stringInTextField.toDoubleOrNull()
        if (cost == null || cost == 0.00){
            binding.output.text = "You Must Enter a Bill amount"
        }else{
            var num1 = (cost * 0.10) + cost
            var round1 = String.format("%.2f",num1)
            var num2 = (cost * 0.15) + cost
            var round2 = String.format("%.2f",num2)
            var num3 = (cost * 0.20) + cost
            var round3 = String.format("%.2f",num3)
            binding.output.text = """
                The tips are as follows:
                10% = ${round1}
                15% = ${round2}
                20% = ${round3}
            """.trimIndent()


        }
    }



}