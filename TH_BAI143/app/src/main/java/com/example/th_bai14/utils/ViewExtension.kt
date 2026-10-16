package com.example.th_bai14.utils

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast

class ViewExtension {
    fun Context.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    fun View.show() {
        this.visibility = View.VISIBLE
    }
    fun View.gone(){
        this.visibility = View.GONE
    }
    fun View.invisible(){
        this.visibility = View.INVISIBLE
    }
    fun EditText.trimmedText() : String =
        this.text.toString().trim()

    fun Double.toAcademicRanking(): String {
        when{
            this >= 3.6 -> return "Xuất xắc (Excellent)"
            this >= 3.2 -> return "Giỏi (Very Good)"
            this >= 2.5 -> return "Khá (Good)"
            this >= 2.0 -> return "Trung bình (Average)"
            this >= 1.0 -> return "Yếu (Weak)"
            else -> return "Kém (Poor)"
        }
    }

}