package com.example.dinnerdecider.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dinnerdecider.Model.Player
import com.example.dinnerdecider.R
import com.example.dinnerdecider.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null)  {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun mensClicked(view: View) {
        womensBtn.isChecked = false
        coedBtn.isChecked = false
        player.league = "mens"
    }

    fun womensClicked(view: View) {
        mensBtn.isChecked = false
        coedBtn.isChecked = false
        player.league = "womens"
    }

    fun coedClicked(view: View) {
        womensBtn.isChecked = false
        mensBtn.isChecked = false
        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View) {
        if (womensBtn.isChecked == false && mensBtn.isChecked == false && coedBtn.isChecked == false) {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        } else {
            if (player.league != "") {
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(skillIntent)
            } else {
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
