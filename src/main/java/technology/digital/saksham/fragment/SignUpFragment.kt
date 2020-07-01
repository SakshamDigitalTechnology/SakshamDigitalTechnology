package technology.digital.saksham.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import technology.digital.saksham.R
import technology.digital.saksham.util.AppUtil
import technology.digital.saksham.util.CheckMailPattern
import java.util.*

class SignUpFragment : Fragment() {

    var mobilenumber_editext: EditText? = null
    var password_editext: EditText? = null
    var email_editext: EditText? = null
    var username_editext: EditText? = null
    var signup_button: Button? = null
    private var firebaseDatabase: FirebaseDatabase? = null
    private var mRef: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_sign_up_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseDatabase = FirebaseDatabase.getInstance()
        mRef = firebaseDatabase!!.getReference("StudentInformation")

        findcomponentId(view)
        signupbuttonclick(view)


    }

    private fun signupbuttonclick(view: View) {

        signup_button!!.setOnClickListener({

            if (checkValid()) {

                uploadDataOnFireBase()

            }

        })

    }

    private fun uploadDataOnFireBase() {
        val key = mRef!!.push().key
        val data: MutableMap<String, Any> =
            HashMap()
        data["mobilenumber"] = mobilenumber_editext!!.text.toString().trim()
        data["password"] = password_editext!!.text.toString().trim()
        data["emailaddress"] = email_editext!!.text.toString().trim()
        data["username"] = username_editext!!.text.toString().trim()
        mRef!!.child(key!!).setValue(data)
        Toast.makeText(context, "Inserted Successfully Please Goto Login ", Toast.LENGTH_SHORT)
            .show()


    }

    private fun checkValid(): Boolean {

        if (mobilenumber_editext!!.text.toString().isEmpty()) {
            AppUtil.showCustomDialog(context, "Enter Mobile Number")
            return false
        }
        if (mobilenumber_editext!!.text.toString().length != 10) {
            AppUtil.showCustomDialog(context, "Enter Valid Mobile Number")
            return false
        }
        if (password_editext!!.text.toString().isEmpty()) {
            AppUtil.showCustomDialog(context, "Enter Valid Password")
            return false
        }
        if (email_editext!!.text.toString().isEmpty()) {
            AppUtil.showCustomDialog(context, "Enter Email Address")
            return false
        }
        if (!CheckMailPattern.isCorerectEmailPattern(email_editext!!.text.toString())) {
            AppUtil.showCustomDialog(context, "Enter Valid Email Address")
            return false
        }
        if (username_editext!!.text.toString().isEmpty()) {
            AppUtil.showCustomDialog(context, "Enter UserName")
            return false
        }
        return true

    }

    private fun findcomponentId(view: View) {

        mobilenumber_editext = view.findViewById(R.id.signup_mobilenumber)
        password_editext = view.findViewById(R.id.signup_password)
        email_editext = view.findViewById(R.id.signup_emailaddress)
        username_editext = view.findViewById(R.id.signup_username)
        signup_button = view.findViewById(R.id.signup_button)


    }


}