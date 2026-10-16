package com.example.th_bai14

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.th_bai14.databinding.ActivityMainBinding
import com.example.th_bai14.model.Student
import com.example.th_bai14.utils.toAcademicRanking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var student: Student
    companion object {
        private const val KEY_STUDENT_DATA = "EXTRA_KEY_STUDENT"
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_STUDENT_DATA, student)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        student = Student("2415053122221", "Phạm Nhật Khoa", 3.75, "24T2")
        if (savedInstanceState != null) {
            val savedStudent = savedInstanceState.getSerializable(KEY_STUDENT_DATA) as Student?
            savedStudent ?.let{student = it}
        }
        binding.textView3.text = "GPA: ${student.gpa} (${student.gpa.toAcademicRanking()})"
        binding.textView.text = "Họ và tên: ${student.name}"
        binding.textView2.text = "MSSV: ${student.id}  Lớp: ${student.classOf}"
        binding.btnUpdate.setOnClickListener {
            val newGpa = binding.editGpa.text.toString().toDoubleOrNull()
            if (newGpa == null || newGpa !in 0.0..4.0) {
                binding.editGpa.error = "GPA phải nằm trong khoảng (0.0 - 4.0)"
                binding.editGpa.requestFocus()
                return@setOnClickListener
            }
            else{
                student.gpa = newGpa
                binding.textView3.text = "GPA: $newGpa (${newGpa.toAcademicRanking()})"
            }
        }
    }
}