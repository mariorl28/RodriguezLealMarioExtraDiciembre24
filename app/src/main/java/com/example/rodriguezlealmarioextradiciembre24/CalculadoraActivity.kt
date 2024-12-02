package com.example.rodriguezlealmarioextradiciembre24

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentNumber: String = ""
    private var previousNumber: String = ""
    private var operation: String = ""
    private var isOperationPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        display = findViewById(R.id.tvDisplay)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener { appendNumber((it as Button).text.toString()) }
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener { setOperation("+") }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { setOperation("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { setOperation("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { setOperation("/") }

        findViewById<Button>(R.id.btnClear).setOnClickListener { clear() }
        findViewById<Button>(R.id.btnEqual).setOnClickListener { calculate() }
        findViewById<Button>(R.id.btnInvert).setOnClickListener { invertNumber() }
    }

    private fun appendNumber(number: String) {
        if (isOperationPressed) {
            currentNumber = ""
            isOperationPressed = false
        }
        currentNumber += number
        display.text = currentNumber
    }

    private fun setOperation(op: String) {
        if (currentNumber.isNotEmpty()) {
            previousNumber = currentNumber
            operation = op
            isOperationPressed = true
        }
    }

    private fun calculate() {
        if (previousNumber.isNotEmpty() && currentNumber.isNotEmpty()) {
            val result = when (operation) {
                "+" -> previousNumber.toDouble() + currentNumber.toDouble()
                "-" -> previousNumber.toDouble() - currentNumber.toDouble()
                "*" -> previousNumber.toDouble() * currentNumber.toDouble()
                "/" -> previousNumber.toDouble() / currentNumber.toDouble()
                else -> 0.0
            }
            display.text = result.toString()
            currentNumber = result.toString()
            previousNumber = ""
            operation = ""
        }
    }

    private fun clear() {
        currentNumber = ""
        previousNumber = ""
        operation = ""
        display.text = "0"
    }

    private fun invertNumber() {
        if (currentNumber.isNotEmpty()) {
            currentNumber = currentNumber.reversed()
            display.text = currentNumber
        }
    }
}