package com.baggio.calculator

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Result
        val expression : TextView = findViewById(R.id.expression)
        val result: TextView = findViewById(R.id.result)

        //Numbers
        val one : TextView = findViewById(R.id.one)
        one.setOnClickListener {
            appendExpression("1", true, result, expression)
        }

        val two : TextView = findViewById(R.id.two)
        two.setOnClickListener {
            appendExpression("2", true, result, expression)
        }

        val three : TextView = findViewById(R.id.three)
        three.setOnClickListener {
            appendExpression("3", true, result, expression)
        }

        val four : TextView = findViewById(R.id.four)
        four.setOnClickListener {
            appendExpression("4", true, result, expression)
        }

        val five : TextView = findViewById(R.id.five)
        five.setOnClickListener {
            appendExpression("5", true, result, expression)
        }

        val six : TextView = findViewById(R.id.six)
        six.setOnClickListener {
            appendExpression("6", true, result, expression)
        }

        val seven : TextView = findViewById(R.id.seven)
        seven.setOnClickListener {
            appendExpression("7", true, result, expression)
        }

        val eight : TextView = findViewById(R.id.eight)
        eight.setOnClickListener {
            appendExpression("8", true, result, expression)
        }

        val nine : TextView = findViewById(R.id.nine)
        nine.setOnClickListener {
            appendExpression("9", true, result, expression)
        }

        val dot : TextView = findViewById(R.id.dot)
        dot.setOnClickListener {
            appendExpression(".", true, result, expression)
        }


        //Operators
        val plus : TextView = findViewById(R.id.plus)

        plus.setOnClickListener {
            appendExpression("+" ,false, result, expression)
        }

        val minus : TextView = findViewById(R.id.minus)

        minus.setOnClickListener {
            appendExpression("-" ,false, result, expression)
        }

        val divide : TextView = findViewById(R.id.divide)

        divide.setOnClickListener {
            appendExpression("/" ,false, result, expression)
        }

        val multiply : TextView = findViewById(R.id.multiply)

        multiply.setOnClickListener {
            appendExpression("*" ,false, result, expression)
        }

        val close : TextView = findViewById(R.id.close)

        close.setOnClickListener {
            appendExpression(")" ,false, result, expression)
        }


        val open : TextView = findViewById(R.id.open)

        open.setOnClickListener {
            appendExpression("(" ,false, result, expression)
        }

        val clean : TextView = findViewById(R.id.clean)

        clean.setOnClickListener {
            result.text = ""
            expression.text = ""
        }

        val back : ImageView = findViewById(R.id.back)
        back.setOnClickListener{
            val string = expression.text.toString()
            if (string.isNotEmpty()){
                expression.text = string.substring(0, string.length-1);
            }
            result.text = ""
        }

        val equals : TextView = findViewById(R.id.equals)

        equals.setOnClickListener {

            try {
                val tempExpression = ExpressionBuilder(expression.text.toString()).build();
                val tempResult = tempExpression.evaluate()
                val longResult = tempResult.toLong();

                if (tempResult == longResult.toDouble()){
                    result.text = longResult.toString()
                }else{
                    result.text = tempResult.toString()
                }


            }catch (e : Exception){
                Log.d("Exception", " message : " + e.message)
            }

        }

    }


    private fun appendExpression(string: String, canClear: Boolean, result : TextView, expression: TextView) {
        if (canClear) {
            result.text = ""
            expression.append(string)
        }else{
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }

}

