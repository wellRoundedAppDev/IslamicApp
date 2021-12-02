package com.example.islamicapp.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamicapp.R
import com.example.islamicapp.ui.home.fragments.HadeethFragment
import com.example.islamicapp.ui.home.fragments.QuranFragment
import com.example.islamicapp.ui.home.fragments.RadioFragment
import com.example.islamicapp.ui.home.fragments.TasbeehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation = findViewById(R.id.bottom_navigation_bar)

        pushFragment(QuranFragment())


        bottomNavigation.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                if (item.itemId == R.id.navigation_quran) {
                    pushFragment(QuranFragment())
                } else if (item.itemId == R.id.navigation_hadeeth) {
                    pushFragment(HadeethFragment())
                } else if (item.itemId == R.id.navigation_sebha) {
                    pushFragment(TasbeehFragment())
                } else if (item.itemId == R.id.navigation_radio) {
                    pushFragment(RadioFragment())
                }
                return true
            }
        })


        // bottomNavigation.selectedItemId = R.id.navigation_quran// another way is to remove pushFragment(QuranFragment())
        //and insert this line
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}