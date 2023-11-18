package com.rushil.codsoft_quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.rushil.codsoft_quotes.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var quoteNo=0
    private lateinit var quotesArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quotesArray=resources.getStringArray(R.array.quotes)

        binding.btn.setOnClickListener{
            if(binding.btn.text.equals("Close App"))
            {
                val builder = AlertDialog.Builder(this)
                    .setTitle("Confirm")
                    .setMessage("Are you really want to exit?")
                    .setPositiveButton("Yes",null)
                    .setNegativeButton("No",null)
                    .show()

                val positiveButton =builder.getButton(AlertDialog.BUTTON_POSITIVE)

                positiveButton.setOnClickListener {
                    exitProcess(0)
                }

            }
            else{
                if(quoteNo<10)
                {
                    setNextQuote(quoteNo)
                    quoteNo++
                }
                else
                {
                    binding.quoteTv.text="quotes are over"
                    binding.btn.text ="Close App"
                }
            }
        }
    }

    private fun setNextQuote(nextQuoteNo: Int)
    {
        binding.quoteTv.text=quotesArray[nextQuoteNo]
    }
}