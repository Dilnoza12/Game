package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
       var rightAnswersCount=intent.getIntExtra(Main2Activity.RIGHT_ANSWERS_COUNT,0)
        tvRight.text="$rightAnswersCount/${Main2Activity.LEVEL_COUNT}"
        Restartbtn.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
