package com.example.chsb_project

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chsb_project.databinding.ActivityRegistrationBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Registration : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var userList: MutableList<User>
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signIn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        val type = object : TypeToken<List<User>>() {}.type
        val gson = Gson()

        getPreferences = getSharedPreferences("login", MODE_PRIVATE)
        edit = getPreferences.edit()

        binding.signUp.setOnClickListener {
            if (binding.fullName.text!!.isEmpty() || binding.email.text!!.isEmpty() || binding.password.text!!.isEmpty() || binding.phone.text!!.isEmpty()) {
                Toast.makeText(applicationContext, "Fill all strokes", Toast.LENGTH_LONG).show()
            } else {
                val userName = binding.fullName.text.toString()
                val userEmail = binding.email.text.toString()
                val userPhone = binding.phone.text.toString()
                val userPassword = binding.password.text.toString()
                val userBvn = binding.bvn.text.toString()
                val accauntNumber = binding.accauntNumber.text.toString()
                val str = getPreferences.getString("Users", "")

                if (str == "") {
                    userList = mutableListOf()
                } else {
                    userList = gson.fromJson(str, type)
                }
                userList.add(User(userEmail, userName, userPassword, userPhone, userBvn, accauntNumber))
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                val s = gson.toJson(userList)
                edit.putString("Users", s).apply()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}