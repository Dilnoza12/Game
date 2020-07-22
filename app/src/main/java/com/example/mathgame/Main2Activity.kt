package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.random.Random

class Main2Activity : AppCompatActivity() {
    companion object{
        var LEVEL_COUNT=10
        var RIGHT_ANSWERS_COUNT="rightAnswersCount"
    }


    var firstNumber: Int = 0
    var secondNumber: Int = 0
    var operator: String = ""
    var rightAnswers=0
    var wrongAnswers=0
    var currentLevelCount=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        playGame()
    }

    fun variantClick(button: View) {
        val intent=Intent(this,GameOverActivity::class.java)
        if ((button as Button).text == getRightAnswer().toString()) {
           rightAnswers++
        }
        else{
           wrongAnswers++
        }
        if(currentLevelCount== LEVEL_COUNT){
            val intent=Intent(this,GameOverActivity::class.java)
            intent.putExtra(RIGHT_ANSWERS_COUNT,rightAnswers)
            startActivity(intent)
            finish()
        }
        else{
            playGame()
        }
    }


    private fun playGame() {
        firstNumber = generateRandomNumber(10, 500)
        secondNumber = generateRandomNumber(10, 500)
        operator = generateOperator()
        tv1.text = firstNumber.toString()
        tv3.text = secondNumber.toString()
        tv2.text = operator
        getWrongAnswers()
        setRightAnswer()





    }

    private fun generateRandomNumber(start: Int, end: Int): Int {
        return Random.nextInt(start, end)
    }

    private fun generateOperator(): String {
        return when (generateRandomNumber(0, 4)) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> "-"

        }
    }

    private fun getWrongAnswers() {
        val answer = getRightAnswer()
        val variantA = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(4, 50)
            1 -> answer + generateRandomNumber(4, 50)
            else -> answer + generateRandomNumber(4, 50)
        }
        val variantB = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(4, 50)
            1 -> answer + generateRandomNumber(4, 50)
            else -> answer + generateRandomNumber(4, 50)
        }

        val variantC = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(4, 50)
            1 -> answer + generateRandomNumber(4, 50)
            else -> answer + generateRandomNumber(4, 50)
        }

        val variantD = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(4, 50)
            1 -> answer + generateRandomNumber(4, 50)
            else -> answer + generateRandomNumber(4, 50)
        }
        btn1.text = variantA.toString()
        btn2.text = variantB.toString()
        btn3.text = variantC.toString()
        btn4.text = variantD.toString()
    }

    private fun getRightAnswer(): Int {
        firstNumber=secondNumber*generateRandomNumber(10,100)
        var res=firstNumber/secondNumber
        return when (operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> res
            else -> firstNumber + secondNumber
        }
    }

    private fun setRightAnswer() {
        val answer = getRightAnswer()
        when (generateRandomNumber(0, 4)) {
            0 -> btn1.text = answer.toString()
            1 -> btn2.text = answer.toString()
            2 -> btn3.text = answer.toString()
            3 -> btn4.text = answer.toString()
        }
    }


}
