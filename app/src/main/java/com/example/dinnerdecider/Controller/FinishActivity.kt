package com.example.dinnerdecider.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dinnerdecider.Model.Player
import com.example.dinnerdecider.R
import com.example.dinnerdecider.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchingTxtView.text = "Looking for " + player.league + " " + player.level + " league near you..."
    }
}
