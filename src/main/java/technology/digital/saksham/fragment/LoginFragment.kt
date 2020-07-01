package technology.digital.saksham.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.facebook.*
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import org.json.JSONObject
import technology.digital.saksham.R
import technology.digital.saksham.activity.CourseActivity
import technology.digital.saksham.model.LoginModel
import technology.digital.saksham.util.AppUtil
import technology.digital.saksham.util.SharedPref
import java.util.*


class LoginFragment : Fragment() {
    var edittext_mobilenumber: EditText? = null
    var editetext_password: EditText? = null
    var button_login: Button? = null
    private var firebaseDatabase: FirebaseDatabase? = null
    private var mRef: DatabaseReference? = null
    private var mobilenumberlist: ArrayList<String>? = null
    private var passwordlist: ArrayList<String>? = null
    var foralldata = ArrayList<LoginModel>()
    var loginModel: LoginModel? = null
    private var mobilenumber: String? = null
    private var password: String? = null
    var google_image_view: ImageView? = null
    private var mAuth: FirebaseAuth? = null


    // Google Login
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 9001
    lateinit var mSignInButton: SignInButton


    //FCEBOOK LOGIN
    private var callbackManager: CallbackManager? = null
    private val EMAIL = "email"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FacebookSdk.sdkInitialize(context)


        return inflater.inflate(R.layout.activity_login_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findcomponentbyID(view)
        loginbuttonclick(view)
        googleloginCall(view)
        facebookLoginCall(view)


        firebaseDatabase = FirebaseDatabase.getInstance()
        mRef = firebaseDatabase!!.getReference("StudentInformation")
        mAuth = FirebaseAuth.getInstance()


    }


    private fun findcomponentbyID(view: View) {

        edittext_mobilenumber = view.findViewById(R.id.login_mobilenumber)
        editetext_password = view.findViewById(R.id.login_password)
        button_login = view.findViewById(R.id.login_button)


    }

    private fun facebookLoginCall(view: View) {
        val loginButton = view.findViewById<LoginButton>(R.id.facebook_login_button)

        loginButton.setOnClickListener({
            loginButton.setReadPermissions(listOf(EMAIL))
            callbackManager = CallbackManager.Factory.create()
            loginButton.fragment = this

            loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
                override fun onSuccess(loginResult: LoginResult?) {
                    Log.d("MainActivity", "Facebook token: " + loginResult!!.accessToken.token)


                    val request = GraphRequest.newMeRequest(
                        loginResult.accessToken,
                        GraphRequest.GraphJSONObjectCallback { obj: JSONObject, response: GraphResponse ->


                            val key = mRef!!.push().key
                            val data: MutableMap<String, Any> =
                                HashMap()
                            data["emailaddress"] = obj.get("email")
                            data["username"] = obj.get("name")
                            mRef!!.child(key!!).setValue(data)

                            SharedPref.getInstance(context).wirteUserName("" + obj.get("name"))
                            SharedPref.getInstance(context).wirteUserEmail("" + obj.get("email"))
                            SharedPref.getInstance(context).setLoginState(true)

                        })

                    val parameters = Bundle()
                    parameters.putString("fields", "name,email,id,picture.type(large)")
                    request.parameters = parameters
                    request.executeAsync()

                    val intent = Intent(context, CourseActivity::class.java)
                    intent.putExtra("loginwith", "facebook")
                    startActivity(intent)
                    activity!!.finish()


                }

                override fun onCancel() {
                }

                override fun onError(exception: FacebookException) {
                }
            })

        })

    }

    private fun googleloginCall(view: View) {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("23195516678-hvt6kn3lglcn6phmun93faknvvf6tga3.apps.googleusercontent.com")
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(view.context, gso)
        mSignInButton = view.findViewById(R.id.google_sign_in_button)

        mSignInButton.setOnClickListener({


            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(
                signInIntent, RC_SIGN_IN
            )


        })

    }

    private fun loginbuttonclick(view: View) {

        button_login!!.setOnClickListener({

            if (checkValid()) {
                mobilenumber = edittext_mobilenumber!!.text.toString()
                password = editetext_password!!.text.toString()

                mobilenumberlist = ArrayList()
                passwordlist = ArrayList()
                mRef!!.addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (mydata in dataSnapshot.children) {
                            val map = mydata.value as Map<String, String>?
                            passwordlist!!.add("" + map!!["password"])
                            mobilenumberlist!!.add("" + map["mobilenumber"])
                            loginModel = LoginModel()
                            loginModel!!.mobilenumber = "" + map["mobilenumber"]
                            loginModel!!.emailaddress = "" + map["emailaddress"]
                            loginModel!!.password = "" + map["password"]

                            loginModel!!.username = "" + map["username"]
                            foralldata.add(loginModel!!)
                        }
                        match_data(
                            passwordlist!!,
                            mobilenumberlist!!,
                            password!!,
                            mobilenumber!!,
                            foralldata
                        )


                    }


                })


            }


        })
    }

    private fun checkValid(): Boolean {

        if (edittext_mobilenumber!!.text.toString().isEmpty()) {
            AppUtil.showCustomDialog(context, "Enter Mobile Number")
            return false
        }
        if (edittext_mobilenumber!!.text.toString().length != 10) {
            AppUtil.showCustomDialog(context, "Enter Valid Mobile Number")
            return false
        }
        if (editetext_password!!.text.toString().isEmpty()) {
            AppUtil.showCustomDialog(context, "Enter Valid Password")
            return false
        }

        return true

    }

    private fun match_data(
        passwordlist: ArrayList<String>,
        mobilenumberlist: ArrayList<String>,
        password: String,
        mobilenumber: String,
        foralldata: ArrayList<LoginModel>
    ) {


        val num = passwordlist.indexOf(password)
        if (num != -1) {

            var username = foralldata[num].username
            var emailaddress = foralldata[num].emailaddress
            var mobilenumber: String? = foralldata[num].mobilenumber
            var password: String? = foralldata[num].password

            val mmm = mobilenumberlist[num]
            if (mobilenumber == mmm) {
                Toast.makeText(
                    context,
                    "Login SuccessFully",
                    Toast.LENGTH_SHORT
                ).show()

                SharedPref.getInstance(context).wirteUserEmail(emailaddress)
                SharedPref.getInstance(context).wirteUserMobilenumber(mobilenumber)
                SharedPref.getInstance(context).wirteUserName(username)
                SharedPref.getInstance(context).wirteUserPassword(password)
                SharedPref.getInstance(context).setLoginState(true)

                val intent = Intent(context, CourseActivity::class.java)
                intent.putExtra("loginwith", "normal")
                startActivity(intent)
                activity!!.finish()

            } else {
                Toast.makeText(
                    context,
                    "Wrong Mobile Number And password try Again!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                context,
                "Wrong Mobile Number And password try Again!!!",
                Toast.LENGTH_SHORT
            ).show()
        }


    }

    private fun handleSignInResult(completeTask: Task<GoogleSignInAccount>?) {

        val account = completeTask!!.getResult(ApiException::class.java)
        val googelid = account?.id ?: ""
        val googleFirstName = account?.givenName ?: ""
        val googleLastName = account?.familyName ?: ""
        val googleEmail = account?.email ?: ""
        val googleProfilePicURL = account?.photoUrl.toString()
        val googleIdToken = account?.idToken ?: ""
        SharedPref.getInstance(context).wirteUserName(googleFirstName + " " + googleLastName)
        SharedPref.getInstance(context).wirteUserEmail(googleEmail)
        SharedPref.getInstance(context).setLoginState(true)


        val key = mRef!!.push().key
        val data: MutableMap<String, Any> =
            HashMap()
        data["emailaddress"] = googleEmail
        data["username"] = googleFirstName + " " + googleLastName
        mRef!!.child(key!!).setValue(data)


        val intent = Intent(context, CourseActivity::class.java)
        intent.putExtra("loginwith", "google")
        startActivity(intent)
        activity!!.finish()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager?.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)

        }

    }
}