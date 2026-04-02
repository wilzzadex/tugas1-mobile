package com.example.tugas1

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val VALID_USER = "admin"
    private val VALID_PASS = "admin123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRegisterText()
        setupListeners()
    }

    private fun setupRegisterText() {
        val full = "Belum punya akun? Daftar"
        val span = SpannableString(full)
        val start = full.indexOf("Daftar")
        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#4F46E5")),
            start,
            full.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        span.setSpan(
            StyleSpan(Typeface.BOLD),
            start,
            full.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvRegister.text = span
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener { doLogin() }
        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Fitur belum tersedia", Toast.LENGTH_SHORT).show()
        }
        binding.tvRegister.setOnClickListener {
            Toast.makeText(this, "Fitur registrasi belum tersedia", Toast.LENGTH_SHORT).show()
        }
        binding.btnGoogle.setOnClickListener {
            Toast.makeText(this, "Login Google belum tersedia", Toast.LENGTH_SHORT).show()
        }
        binding.btnGithub.setOnClickListener {
            Toast.makeText(this, "Login GitHub belum tersedia", Toast.LENGTH_SHORT).show()
        }
    }

    private fun doLogin() {
        binding.tilUsername.error = null
        binding.tilPassword.error = null

        val user = binding.etUsername.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()

        when {
            user.isEmpty() -> {
                binding.tilUsername.error = "Username tidak boleh kosong"
                binding.etUsername.requestFocus()
            }
            user.length < 4 -> {
                binding.tilUsername.error = "Username minimal 4 karakter"
                binding.etUsername.requestFocus()
            }
            pass.isEmpty() -> {
                binding.tilPassword.error = "Password tidak boleh kosong"
                binding.etPassword.requestFocus()
            }
            pass.length < 6 -> {
                binding.tilPassword.error = "Password minimal 6 karakter"
                binding.etPassword.requestFocus()
            }
            user == VALID_USER && pass == VALID_PASS -> showSuccess()
            else -> showError()
        }
    }

    private fun showSuccess() {
        AlertDialog.Builder(this)
            .setTitle("Login Berhasil!")
            .setMessage("Selamat datang, ${binding.etUsername.text}")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .show()
    }

    private fun showError() {
        AlertDialog.Builder(this)
            .setTitle("Login Gagal")
            .setMessage("Username atau password salah.")
            .setPositiveButton("Coba Lagi") { dialog, _ ->
                dialog.dismiss()
                binding.etPassword.text?.clear()
                binding.etPassword.requestFocus()
            }
            .setCancelable(false)
            .show()
    }
}
