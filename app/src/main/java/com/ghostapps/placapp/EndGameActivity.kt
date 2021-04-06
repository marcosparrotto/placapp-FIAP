package com.ghostapps.placapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_end_game.*
import kotlinx.android.synthetic.main.activity_pre_game.*
import kotlinx.android.synthetic.main.activity_score_game.*

class EndGameActivity: AppCompatActivity() {

    companion object {
        const val TIME_WINNER = "winner"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        winnerName.text = intent.getStringExtra(TIME_WINNER)

        EndExitButton.setOnClickListener {
            finish()
        }
    }

}