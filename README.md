# KotlinValidator
Kotlin Validator is a rule-based validation library for Swift and Java
# Screenshots
![Main screen](/screenshots/device-2017-11-02-214730.png) 
## Usage 
Add a dependency to your `build.gradle`:
```
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
   compile 'com.github.noizar:KotlinValidator:v0.1.0'
}
```
```kotlin
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
```
