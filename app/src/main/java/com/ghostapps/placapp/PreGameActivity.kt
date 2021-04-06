package com.ghostapps.placapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pre_game.*

class PreGameActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_game)

        setSupportActionBar(preGameToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        preGameStartGameButton.setOnClickListener {
            val homeTeamName = preGameHomeTeamInput.text.toString()
            val awayTeamName = preGameAwayTeamInput.text.toString()

            val intent = Intent(this, GameScoreActivity::class.java)
            intent.putExtra(GameScoreActivity.TEAM_HOME_NAME, homeTeamName)
            intent.putExtra(GameScoreActivity.TEAM_AWAY_NAME, awayTeamName)
            startActivity(intent)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}