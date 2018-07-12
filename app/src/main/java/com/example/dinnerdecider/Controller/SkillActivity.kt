package com.example.dinnerdecider.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dinnerdecider.Model.Player
import com.example.dinnerdecider.R
import com.example.dinnerdecider.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null)  {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun beginnerClicked(view: View) {
        ballerBtn.isChecked = false
        player.level = "beginner"
    }

    fun ballerClicked(view: View)   {
        beginnerBtn.isChecked = false
        player.level = "baller"
    }

    fun finishClicked(view: View)   {
        if(beginnerBtn.isChecked == false && ballerBtn.isChecked == false)    {
            Toast.makeText(this, "Please select a level.", Toast.LENGTH_SHORT).show()
        }   else    {
            if(player.level != "") {
                val finishIntent = Intent(this, FinishActivity::class.java)
                finishIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(finishIntent)
            }   else {
                Toast.makeText(this, "Please select a level.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
