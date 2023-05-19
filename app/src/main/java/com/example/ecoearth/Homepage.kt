package com.example.ecoearth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ecoearth.databinding.HomepageBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class Homepage : AppCompatActivity() {

    private lateinit var binding: HomepageBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.apply {
            navView.bringToFront()

            setSupportActionBar(toolbar)

            toggle = ActionBarDrawerToggle(
                this@Homepage,
                drawerLayout,
                R.string.open,
                R.string.close
            )

            drawerLayout.addDrawerListener(toggle)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {

                    R.id.nav_home -> {
                        Toast.makeText(this@Homepage, "Home is selected", Toast.LENGTH_SHORT)
                            .show()

                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    R.id.nav_community -> {
                        Toast.makeText(this@Homepage, "Community is selected", Toast.LENGTH_SHORT)
                            .show()
                    }
                    R.id.nav_donation -> {
                        Toast.makeText(this@Homepage, "Donation is selected", Toast.LENGTH_SHORT)
                            .show()
                    }
                    R.id.nav_setting -> {
                        Toast.makeText(
                            this@Homepage, "Setting is selected",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    R.id.logoutbtn -> {
                        Toast.makeText(
                            this@Homepage, "Log Out!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
                true
            }


        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else {
            return super.onOptionsItemSelected(item)
        }


        binding.newbutton.setOnClickListener {
            startActivity(Intent(this, Newspage::class.java))
        }

        binding.tipsbutton.setOnClickListener {
            startActivity(Intent(this, ClimateTips::class.java))
        }

        binding.videobutton.setOnClickListener {
            startActivity(Intent(this, EducationVideo::class.java))
        }
    }


}
