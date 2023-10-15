package com.hideonshroud.icalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView:TextView
    private var operand: Double = 0.0
    private var dotCount:Int = 1
    private var operation:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView = findViewById(R.id.textView)
    }

    fun NumClick(clickedNumber: View){
        if(clickedNumber is Button){
            var result = textView.text.toString()
            var number = clickedNumber.text.toString()
            if (result == "0"){
                result = ""
            }
            textView.text = result + number

        }

    }

    fun DotClick(clickedDot:View){
        if (clickedDot is View){
            var result = textView.text.toString()
            if (dotCount == 1){
                dotCount -= 1

            textView.text = result + "."}
        }

    }

    fun operationClick(clickedView: View){
        if (clickedView is TextView){
            var result = textView.text.toString()

            if (result.isNotEmpty()){
                operand = result.toDouble()
            }
            operation = clickedView.text.toString()

            textView.text = ""

        }
        if (textView.text == "0.0"){
            textView.text = "0"
        }
    }

    fun buclear(clearClicked: View){
        textView.text = "0"
        dotCount = 1
        operand = 0.0
    }

    fun buttonEqual(equalsClicked:View){
        val secOperandText: String = textView.text.toString()
        var secOperand : Double = 0.0

        if(secOperandText.isNotEmpty()){
            secOperand = secOperandText.toDouble()
        }
        when (operation){
            "+" -> textView.text = (operand + secOperand).toString()
            "―" -> textView.text = (operand - secOperand).toString()
            "x" -> textView.text = (operand * secOperand).toString()
            "÷" -> textView.text = (operand / secOperand).toString()
            "%" -> textView.text = (operand / 100 * secOperand).toString()
            "+/-" -> textView.text = (operand * -1).toString()
        }
        if (textView.text.endsWith(".0")){
            textView.text = textView.text.dropLast(2)
        }
    }
}