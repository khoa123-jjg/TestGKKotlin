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
        val student = Student("2415053122221", "Phạm Nhật Khoa", 3.75, "24T2")
        val gpa: Double = 3.75
        binding.textView3.text = "GPA: $student.gpa (${student.gpa.toAcademicRanking()})"
        binding.textView.text = "Họ và tên: ${student.name}  Lớp: ${student.classOf}"
        binding.textView2.text = "MSSV: ${student.id}"
        binding.btnUpdate.setOnClickListener {
            val newGpa = binding.editGpa.text.toString().toDoubleOrNull()
            if (newGpa == null || newGpa !in 0.0..4.0) {
                binding.editGpa.error = "GPA phải nằm trong khoảng (0.0 - 4.0)"
                binding.editGpa.requestFocus()
                return@setOnClickListener
            }
            else{
                binding.textView3.text = "GPA: $newGpa (${newGpa.toAcademicRanking()})"
            }
        }
    }
}