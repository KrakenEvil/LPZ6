package com.example.zadanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.textView
import kotlinx.android.synthetic.main.activity_main.textView2
import layout.Round
import java.lang.Exception
import java.sql.RowId

class MainActivity : AppCompatActivity()//, View.OnClickListener
 {
    private var currentRound = 0

  /*Способ перехода
   override fun onClick(v: View?) {
        v?.let {
            when(it.id) {
                R.id.button ->  proccesRound(1)
                R.id.button2 -> proccesRound(2)
                R.id.button3 -> proccesRound(3)
                R.id.button4 -> proccesRound(4)
                else -> return
            }

        }


    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /* Способ перехода
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)*/
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        fillRounds()
        UpdateUI()
        /*
        button1.setOnClickListener(View.OnClickListener(){
            fun onClick(view: View)
            {
                proccesRound(1)
            }
        })
        button2.setOnClickListener(View.OnClickListener(){
            fun onClick2(view: View)
            {
                proccesRound(2)
            }
        })
        button3.setOnClickListener(View.OnClickListener(){
            fun onClick3(view: View)
            {
                proccesRound(3)
            }
        })
        button4.setOnClickListener(View.OnClickListener(){
            fun onClick4(view: View)
            {
                proccesRound(4)
            }
        })
        */



    }
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private val rounds = mutableListOf<Round>()
    private  fun fillRounds() {
        rounds.run {
            add(Round("Что такое Луна?", "Звезда","Планета", "Спутник",
                "Круг сыра", 3, 0))
            add(Round("В каком году запущен первый спутник?", "1957", "1967",
                "1965", "1969", 1, 100))
            add(Round("Сколько спутников у Марса?", "0", "1", "2",
                "3", 3, 1000))
            add(Round("Как называется спутник Плутона?", "Нет спутников",
                "Харон", "Энцелад", "Ио", 2, 10000))
            add(Round("Какой крупнейший спутник у Юпитера?", "Европа", "Каллисто",
                "Титан", "Ганимед", 4, 100000))
        }
    }
    private  fun UpdateUI()
    {

        textView.text =rounds[currentRound].question
        textView2.text =rounds[currentRound].value.toString()
        button1.text = rounds[currentRound].answer1
        button2.text = rounds[currentRound].answer2
        button3.text = rounds[currentRound].answer3
        button4.text = rounds[currentRound].answer4



    }
    private fun check(givenId: Int) = (givenId == rounds[currentRound].rightId)

    private fun  goNext():Boolean
    {
        if (currentRound >=rounds.size - 1) return false
        currentRound++
        UpdateUI()
        return true
    }
    fun proccesRound(givenId: Int)
    {
        if(check(givenId))
        {
            if(!goNext())
            {
                Toast.makeText(this, getString(R.string.wintext),Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        else
        {
            Toast.makeText(this, getString(R.string.lostext), Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun button2Click(view: View) {
        try {
            val id = view.tag.toString().toInt()
            proccesRound(id)
        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }
    fun button3Click(view: View) {
        try {
            val id = view.tag.toString().toInt()
            proccesRound(id)
        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }
    fun button4Click(view: View) {
        try {
            val id = view.tag.toString().toInt()
            proccesRound(id)
        }
        catch (e:Exception)
        {
            e.printStackTrace()
        }
    }
    fun button1Click(view: View) {
       try {
           val id = view.tag.toString().toInt()
           proccesRound(id)
       }
       catch (e:Exception)
       {
           e.printStackTrace()
       }
    }

}