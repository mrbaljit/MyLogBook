package com.example.btdigitalnz.myapplication


import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_obs_form.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.widget.ArrayAdapter
import android.widget.Spinner




class ActivityObsForm : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obs_form)

        val spinner = findViewById<View>(R.id.spinner) as Spinner
// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item)
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
// Apply the adapter to the spinner
        spinner.adapter = adapter

   btn_show_date.setOnClickListener {
       var formate = SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH)
       var now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                //val selectedDate = Calendar.getInstance()
                now.set(Calendar.YEAR,year)
                now.set(Calendar.MONTH,month)
                now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                val date = formate.format(now.time)
                btn_show_date.text = date
            },
                    now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()

   }


    }






}
