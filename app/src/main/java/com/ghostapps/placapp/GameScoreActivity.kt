package com.ghostapps.placapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score_game.*

class GameScoreActivity: AppCompatActivity() {

    companion object {
        const val TEAM_HOME_NAME = "home_team_name"
        const val TEAM_AWAY_NAME = "away_team_name"
    }
    
    var homeTeamScore = 0
    var awayTeamScore = 0
    var homeTeamSets = 0
    var awayTeamSets = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_game)


        var homeName = intent.getStringExtra(TEAM_HOME_NAME)
        var awayName = intent.getStringExtra(TEAM_AWAY_NAME)

        gameScoreHomeTeamName.text = homeName
        gameScoreAwayTeamName.text = awayName

        gameScoreHomeIncrease.setOnClickListener { 
            homeTeamScore++
            if (homeTeamScore > 24 && ((homeTeamScore - awayTeamScore)>1)) {
                homeTeamScore = 0
                awayTeamScore = 0
                homeTeamSets++
            }
            updateScore()
            if(homeTeamSets>2) {
                val intent = Intent(this, EndGameActivity::class.java)
                intent.putExtra(EndGameActivity.TIME_WINNER, homeName)
                startActivity(intent)
                finish()
            }
        }
        
        gameScoreHomeDecrease.setOnClickListener { 
            if (homeTeamScore > 0) homeTeamScore--
            updateScore()
        }
        
        gameScoreAwayIncrease.setOnClickListener {  
            awayTeamScore++
            if (awayTeamScore > 24 && ((awayTeamScore - homeTeamScore)>1)) {
                homeTeamScore = 0
                awayTeamScore = 0
                awayTeamSets++
            }
            updateScore()
            if(awayTeamSets>2) {
                val intent = Intent(this, EndGameActivity::class.java)
                intent.putExtra(EndGameActivity.TIME_WINNER, awayName)
                startActivity(intent)
                finish()
            }
        }
        
        gameScoreAwayDecrease.setOnClickListener { 
            if (awayTeamScore > 0) awayTeamScore--
            updateScore()
        }

        gameScoreExitButton.setOnClickListener {
            finish()
        }
    }
    
    private fun updateScore() {
        gameScoreHomeTeamScore.text = String.format("%02d", homeTeamScore)
        gameScoreAwayTeamScore.text = String.format("%02d", awayTeamScore)
        gameScoreHomeTeamSets.text =  String.format("%02d", homeTeamSets)
        gameScoreAwayTeamSets.text =  String.format("%02d", awayTeamSets)
    }

}