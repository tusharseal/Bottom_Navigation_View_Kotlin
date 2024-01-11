package com.example.bottomnavigationviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigationviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_Home -> loadFragment(HomeFragment(), false)
                R.id.nav_Search -> loadFragment(SearchFragment(), false)
                R.id.nav_Settings -> loadFragment(SettingsFragment(), false)
                R.id.nav_Contact -> loadFragment(ContactFragment(), false)
                R.id.nav_Profile -> loadFragment(ProfileFragment(), true)
            }
            true
        }
        binding.bnView.selectedItemId = R.id.nav_Home
    }

    private fun loadFragment(fragment: Fragment?, flag: Boolean) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        if (flag) ft.add(R.id.frameLayout, fragment!!) else ft.replace(R.id.frameLayout, fragment!!)
        ft.commit()
    }
}