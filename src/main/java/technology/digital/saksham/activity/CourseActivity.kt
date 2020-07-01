package technology.digital.saksham.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.tabs.TabLayout
import technology.digital.saksham.R
import technology.digital.saksham.fragment.AllTechnologyFragment
import technology.digital.saksham.fragment.HomeFragment
import technology.digital.saksham.fragment.MoreFragment
import technology.digital.saksham.fragment.ProfileFragment
import technology.digital.saksham.util.AppUtil
import technology.digital.saksham.util.SharedPref

class CourseActivity : AppCompatActivity() {
    lateinit var mGoogleSignInClient: GoogleSignInClient
    var loginwithtext: String? = null
    var sharedPref: SharedPref? = null
    var tabLayout: TabLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        logoutmethod()
        findcomponentid()
        actionOnTabs()


    }

    private fun actionOnTabs() {


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, HomeFragment(), "Home")
            .commit()

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when (tab!!.position) {

                    0 ->

                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, HomeFragment(), "Home")
                            .commit()

                    1 ->

                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, AllTechnologyFragment(), "AllTechnology")
                            .commit()
                    2 ->
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, ProfileFragment(), "Profile")
                            .commit()

                    3 ->
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, MoreFragment(), "More")
                            .commit()


                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

                when (tab!!.position) {

                    0 ->

                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, HomeFragment(), "Home")
                            .commit()

                    1 ->
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, AllTechnologyFragment(), "AllTechnology")
                            .commit()
                    2 ->
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, ProfileFragment(), "Profile")
                            .commit()

                    3 ->
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.root_layout, MoreFragment(), "More")
                            .commit()


                }


            }
        })
    }

    private fun logoutmethod() {
        sharedPref = SharedPref.getInstance(this)
        loginwithtext = intent.getStringExtra("loginwith")
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("23195516678-hvt6kn3lglcn6phmun93faknvvf6tga3.apps.googleusercontent.com")
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun findcomponentid() {
        tabLayout = findViewById(R.id.tabs)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.coursemenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {


                if (loginwithtext.equals("facebook")) {
                    LoginManager.getInstance().logOut()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "LOGOUT SuccessFully", Toast.LENGTH_LONG).show()
                    sharedPref!!.clearPreference()

                } else if (loginwithtext.equals("google")) {
                    mGoogleSignInClient.signOut()
                        .addOnCompleteListener(this) {


                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                            Toast.makeText(this, "LOGOUT SuccessFully", Toast.LENGTH_LONG).show()
                            sharedPref!!.clearPreference()
                        }
                } else if (loginwithtext.equals("normal")) {

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "LOGOUT SuccessFully", Toast.LENGTH_LONG).show()
                    sharedPref!!.clearPreference()

                }
                return true


            }
            else -> super.onOptionsItemSelected(item)

        }


    }


    override fun onBackPressed() {
        AppUtil.showExitAlert(this, "Are you sure you want to exit")


    }
}