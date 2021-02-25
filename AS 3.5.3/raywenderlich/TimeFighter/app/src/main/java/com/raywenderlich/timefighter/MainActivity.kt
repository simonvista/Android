package com.raywenderlich.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity () {
    internal var score=0
    internal var gameStarted=false
    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDown:Long=60000
    internal val countDownInterval:Long=1000
    internal lateinit var tapMeButton: Button
    internal lateinit var gameScoreTextView: TextView
    internal lateinit var timeLeftTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Access to coponents
        tapMeButton=findViewById(R.id.tapMeButton)
        gameScoreTextView=findViewById(R.id.gameScoreTextView)
        timeLeftTextView=findViewById(R.id.timeLeftTextView)
        tapMeButton.setOnClickListener {
            view->incrementScore()
        }
//        Set initial value of gameScore to 0
        resetGame()
//        gameScoreTextView.text=getString(R.string.yourScore,score)
    }
    private fun resetGame(): Unit {
        score=0
        gameScoreTextView.text=getString(R.string.yourScore,score)
        val initialTimeLeft=initialCountDown/1000
        timeLeftTextView.text=getString(R.string.timeLeft,initialTimeLeft)
        countDownTimer=object:CountDownTimer(initialCountDown,countDownInterval){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft=millisUntilFinished/1000
                timeLeftTextView.text=getString(R.string.timeLeft,timeLeft)

            }

            override fun onFinish() {
                stopGame()
            }
        }
        gameStarted=false
    }
    private fun incrementScore() {
        if(!gameStarted){
            startGame()
        }
        /*if(!gameStarted){
            countDownTimer.start()
            gameStarted=true
        }*/
        score++
        val newScore=getString(R.string.yourScore,score)
        gameScoreTextView.text=newScore

    }
    private fun startGame(): Unit {
        countDownTimer.start()
        gameStarted=true
    }
    private fun stopGame(): Unit {
        Toast.makeText(this,getString(R.string.gameOverMessage,score),Toast.LENGTH_LONG).show()
        resetGame()
    }
}
