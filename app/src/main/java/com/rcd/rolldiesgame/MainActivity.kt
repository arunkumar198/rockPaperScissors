package com.rcd.rolldiesgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var rollButton: Button? = null
    var dicePlayer: ImageView? = null
    var diceComputer: ImageView? = null
    var playerScoreNumber: Int = 0
    var computerScoreNumber: Int =0
    var displayPlayerScore: TextView? = null
    var displayComputerScore: TextView? = null
    var displayWinner: TextView? = null
    var restartButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.diceButton)
        dicePlayer = findViewById(R.id.dicePlayer)
        diceComputer = findViewById(R.id.diceComputer)
        displayPlayerScore = findViewById(R.id.player_score)
        displayComputerScore = findViewById(R.id.computer_score)
        displayWinner = findViewById(R.id.winner)
        restartButton = findViewById(R.id.restart)

        rollButton?.setOnClickListener {
            restartButton?.isClickable = false
            val randomPlayerNumber = (1..6).random()
            dicePlayer?.setImageResource(getDiceImage(randomPlayerNumber))
            val randomComputerNumber = (1..6).random()
            diceComputer?.setImageResource(getDiceImage(randomComputerNumber))
            playerScoreNumber += randomPlayerNumber
            computerScoreNumber += randomComputerNumber
            displayPlayerScore?.text = playerScoreNumber.toString()
            displayComputerScore?.text = computerScoreNumber.toString()

            if(computerScoreNumber >=50 && playerScoreNumber >=50){
                displayWinner?.text = "Draw the game!!"
                rollButton?.isClickable = false
                restartButton?.isClickable = true
            }

            else if (playerScoreNumber >= 50) {
                displayWinner?.text = "🎉🎉🎉Player is winner🎉🎉🎉"
                rollButton?.isClickable = false
                restartButton?.isClickable = true
                dicePlayer?.setImageResource(R.drawable.winner)
            } else if (computerScoreNumber >= 50) {
                displayWinner?.text = "🎉🎉🎉Computer is winner🎉🎉🎉"
                rollButton?.isClickable = false
                restartButton?.isClickable = true
                dicePlayer?.setImageResource(R.drawable.lose)
                diceComputer?.setImageResource(R.drawable.winner)
            } else {
                displayWinner?.text = ""
            }
        }

        restartButton?.setOnClickListener {
            playerScoreNumber = 0
            computerScoreNumber = 0
            displayPlayerScore?.text = playerScoreNumber.toString()
            displayComputerScore?.text = computerScoreNumber.toString()
            dicePlayer?.setImageResource(R.drawable.dice6)
            diceComputer?.setImageResource(R.drawable.dice6)
            displayWinner?.text = ""
            rollButton?.isClickable = true
        }
    }

    fun getDiceImage(number: Int): Int {
        return when (number) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
    }
}
