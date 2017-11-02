package nlab.com.simplevalidationexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import nlab.com.simplevalidation.Validation

import nlab.com.simplevalidation.ValidationDelegate


class MainActivity : AppCompatActivity(),ValidationDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var validator = Validation(this)

        validator.register().requiredRule(username,"Invalid username","username")
        validator.register().emailRule(email,"invalid email","email")
        validator.register().confirmationRule(confrim_email,email,"invalid email","confirm email")
        validator.register().regexRule(password,paswword_input,"^(?=.*[0-9])",
                "Invalid password combination","password")
        validator.register().lengthRule(password,paswword_input,4,5,
                "Invalid Length","password")
        register.setOnClickListener{
            validator.validation()
        }
    }

    override fun validationSuccess(data: HashMap<String, String>) {
        Log.d("Usename: ", data["username"])
        Log.d("Email: ", data["email"])
        Log.d("Confirm Email: ", data["confirm email"])
        Log.d("Password: ", data["password"])



    }
}
