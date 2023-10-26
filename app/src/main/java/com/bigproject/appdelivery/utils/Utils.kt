package com.bigproject.appdelivery.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.util.Patterns
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


object Utils {
    fun isValidEmail(email: String) : Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun getCurrentDate(formatResponse: String?= "yyyy-MM-dd hh:mm:ss"): String {
        var dateCurrent = ""
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern(formatResponse)
            val formatted = current.format(formatter)
            dateCurrent = formatted
            println("Current Date and Time is: $formatted")
        }else{
            val pattern = formatResponse
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(Date())
            dateCurrent = date
            println(date)
        }
        return dateCurrent
    }

    fun getCurrentDate2(formatResponse: String?= "yyyy-MM-dd"): String {
        var dateCurrent = ""
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern(formatResponse)
            val formatted = current.format(formatter)
            dateCurrent = formatted
            println("Current Date and Time is: $formatted")
        }else{
            val pattern = formatResponse
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(Date())
            dateCurrent = date
            println(date)
        }
        return dateCurrent
    }

    fun getCurrentHour(): String{
        var dateCurrent = ""
        val dateFormat: DateFormat = SimpleDateFormat("HH:mm")
        val date = Date()
        val dateformatted: String = dateFormat.format(date)
        dateCurrent = dateformatted
        Log.e("hora", dateCurrent)
        return dateCurrent
    }

    fun getCurrentHourCompleta(): String{
        var dateCurrent = ""
        val dateFormat: DateFormat = SimpleDateFormat("HH:mm:ss")
        val date = Date()
        val dateformatted: String = dateFormat.format(date)
        dateCurrent = dateformatted
        Log.e("hora", dateCurrent)
        return dateCurrent
    }

    fun getCurrentHourAddingMinutes(addingMin : Int): String{
        var dateCurrent = ""
        try{
            val date = Calendar.getInstance()
            System.out.println("Current Date and TIme : " + date.time)
            val timeInSecs = date.timeInMillis
            val afterAdding10Mins = Date(timeInSecs + addingMin * 60 * 1000)
            val dateFormat: DateFormat = SimpleDateFormat("HH:mm")
            val dateformatted: String = dateFormat.format(afterAdding10Mins)
            dateCurrent = dateformatted
            println("After adding 10 mins : $dateCurrent")
            return dateCurrent
        }catch (e: Exception){
            e.printStackTrace()
        }
        return dateCurrent
    }

    fun getDiferenciaEntreTimpos(time1: String, time2: String): Long{
        var dateCurrent : Long = 0
        val format = SimpleDateFormat("HH:mm")
        val date1 = format.parse(time1)
        val date2 = format.parse(time2)
        val difference = date1.time - date2.time
        dateCurrent = difference
        println(dateCurrent)
        return dateCurrent
    }

    fun isWhatsappInstalled(context: Context): Boolean {
        val pm: PackageManager = context.getPackageManager()
        val app_installed: Boolean
        app_installed = try {
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            false
        }
        return app_installed
    }
}