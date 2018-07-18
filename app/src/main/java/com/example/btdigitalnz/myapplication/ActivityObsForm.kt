package com.example.btdigitalnz.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ActivityObsForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obs_form)
    }

    fun showDatePickerDialog(v: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }
}
