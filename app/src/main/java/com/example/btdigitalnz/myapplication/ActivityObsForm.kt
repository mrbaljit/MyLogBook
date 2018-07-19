package com.example.btdigitalnz.myapplication


import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_obs_form.*
import java.text.SimpleDateFormat
import java.util.*


class ActivityObsForm : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obs_form)

   btn_show.setOnClickListener {
       var formate = SimpleDateFormat("dd-MMM-YYYY",Locale.ENGLISH)
       var now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                //val selectedDate = Calendar.getInstance()
                now.set(Calendar.YEAR,year)
                now.set(Calendar.MONTH,month)
                now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                val date = formate.format(now.time)
                btn_show.text = date
                d("myTag", "This is my message");
              //  Toast.makeText(this,"date : " + date,Toast.LENGTH_LONG).show()
            },
                    now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
     /*  try {
           if(btn_show.text != "Select Date") {
               val date = formate.parse(btn_show.text.toString())
               now.set(1999,10,8)

           }
       }catch (e:Exception){
           e.printStackTrace()
       }*/
   }


    }






}
