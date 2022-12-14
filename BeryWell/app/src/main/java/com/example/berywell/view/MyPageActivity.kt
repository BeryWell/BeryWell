package com.example.berywell.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.berywell.databinding.ActivityMyPageBinding
import retrofit2.http.Url
import java.lang.Exception

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyPageBinding
    val PERMISSION_Album = 101 // 앨범 권한 처리

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.mypageTb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.mypageUserInfoTv.movementMethod = ScrollingMovementMethod.getInstance()

        binding.mypageIv.setOnClickListener {
            navigatePhotos()
        }

        binding.mypageUserInfoTv.setOnClickListener {
            binding.mypageUserInfoTv.visibility = View.INVISIBLE
            binding.mypageUserInfoEt.visibility = View.VISIBLE

            binding.mypageUserInfoEt.text = Editable.Factory.getInstance().newEditable(binding.mypageUserInfoTv.text)
            binding.mypageFinBtn.visibility = View.INVISIBLE
            binding.mypageEditBtn.visibility = View.VISIBLE
        }


        binding.mypageEditBtn.setOnClickListener {
            binding.mypageUserInfoTv.visibility = View.VISIBLE
            binding.mypageUserInfoEt.visibility = View.INVISIBLE

            binding.mypageUserInfoTv.text = binding.mypageUserInfoEt.text
            binding.mypageFinBtn.visibility = View.VISIBLE
            binding.mypageEditBtn.visibility = View.INVISIBLE
        }

        binding.mypageFinBtn.setOnClickListener{
            val intent = Intent(this@MyPageActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun navigatePhotos() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, 2000)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) {
            Toast.makeText(this, "잘못된 접근입니다", Toast.LENGTH_SHORT).show()
            return
        }

        when (requestCode) {
            2000 -> {
                val selectedImageURI: Uri? = data?.data

                binding.mypageIv.setImageURI(selectedImageURI)

            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this@MyPageActivity, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }

}