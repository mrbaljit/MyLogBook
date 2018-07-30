package com.example.btdigitalnz.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Typeface
import android.view.Menu
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_procedures)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun performAction(v: View) {
        //require to import Button class
        //val btn = findViewById<Button>(R.id.btn_obs)
        //require to import TypedValue class
        //set the button text style bold italic
        //btn.setTypeface(btn.getTypeface(), Typeface.BOLD_ITALIC)
        //set the button's new text
        //btn.text = "You clicked the button"
        //Intent intent = new Intent(this, ActivityObsForm.class)
        val intent = Intent(this, ActivityObsForm::class.java)
        startActivity(intent)

    }

    // create an action bar button
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.proceduresmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
