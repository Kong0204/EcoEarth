package com.example.ecoearth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ecoearth.databinding.HomepageBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class Homepage : AppCompatActivity() {

    private lateinit var binding: HomepageBinding
    private lateinit var auth: FirebaseAuth
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
               R.id.nav_community -> Toast.makeText(applicationContext, "Clicked Community", Toast.LENGTH_SHORT).show()
                R.id.nav_donation -> Toast.makeText(applicationContext, "Clicked Donation", Toast.LENGTH_SHORT).show()
                R.id.nav_setting -> Toast.makeText(applicationContext, "Clicked Setting", Toast.LENGTH_SHORT).show()
                R.id.logoutbtn -> Toast.makeText(applicationContext, "Clicked Log Out", Toast.LENGTH_SHORT).show()
            }
            true
        }

        binding.topAppbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(binding.navView)
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            binding.drawerLayout.closeDrawer(binding.navView)
            true
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toggle.onOptionsItemSelected(item)){
                return true
            }
            return super.onOptionsItemSelected(item)
        }

        binding.logoutbtn.setOnClickListener {
            auth.signOut()
            Intent(this, Loginpage::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
                Toast.makeText(this, "Logout successful!", Toast.LENGTH_SHORT).show()
            }
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
