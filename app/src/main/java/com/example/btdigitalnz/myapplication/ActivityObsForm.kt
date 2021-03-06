package com.example.btdigitalnz.myapplication


import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_obs_form.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class ActivityObsForm : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obs_form)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val spinner = findViewById<View>(R.id.spinner) as Spinner
// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item)
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
// Apply the adapter to the spinner
        spinner.adapter = adapter

   btn_show_date.setOnClickListener {
       var dtFormat = SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH)
       var now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                //val selectedDate = Calendar.getInstance()
                now.set(Calendar.YEAR,year)
                now.set(Calendar.MONTH,month)
                now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                val date = dtFormat.format(now.time)
                btn_show_date.text = date
            },
                    now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()

   }




    }

    // create an action bar button
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.obsmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.itemId

        if (id == R.id.opsSaveBtn) {
            val edit = findViewById<EditText>(R.id.patient_nhi_number)
            val pnotes = findViewById<EditText>(R.id.patient_notes_obs)
            val catVal = findViewById<Spinner>(R.id.spinner)

            val sDate = findViewById<Button>(R.id.btn_show_date)

            Log.i("sDate        ",sDate.text.toString());
            Log.i("nhi number   ",edit.text.toString());
            Log.i("notes        ",pnotes.text.toString());
            Log.i("catVal       ",catVal.selectedItem.toString());
            Toast.makeText(this, edit.text, Toast.LENGTH_LONG).show()
            return true
        }


        return super.onOptionsItemSelected(item)

    }



}
