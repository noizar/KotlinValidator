package nlab.com.simplevalidation

import android.support.design.widget.TextInputLayout
import android.widget.EditText
import nlab.com.simplevalidation.Rules.*

/**
 * Created by noizar on 11/1/17.
 */
class Validation constructor(var delegate: ValidationDelegate) {
    private var  registerData = ArrayList<Any>()
    private var  data  = HashMap<String,String> ()
    private var  erorr = ArrayList<TextInputLayout>()
    private var  errorCount = 0

    inner class register(){
        /** Email Rules register */
        fun emailRule(editText: EditText,message:String,key:String)
                = registerData.add(ValidationData1(editText,EmailRule(editText),message,key))
        fun emailRule(editText: EditText,textInputLayout: TextInputLayout,message: String,
                      key: String)
                = registerData.add(ValidationData2(editText,textInputLayout, EmailRule(editText),
                message,key))

        /** Required Rules register */
        fun requiredRule(editText: EditText,message: String,key: String)
                = registerData.add(ValidationData1(editText,RequireRule(editText),message,key))
        fun requiredRule(editText: EditText,textInputLayout: TextInputLayout,message: String,
                         key: String)
                = registerData.add(ValidationData2(editText,textInputLayout,RequireRule(editText),
                message,key))

        /** Length Rule register  */
        fun lengthRule(editText: EditText,minLength:Int,maxLength:Int,message: String,key: String)
                = registerData.add(ValidationData1(editText,LengthRule(editText,minLength,maxLength)
                ,message,key))
        fun lengthRule(editText: EditText,textInputLayout: TextInputLayout,minLength: Int,
                       maxLength: Int,message: String,key: String)
                = registerData.add(ValidationData2(editText,textInputLayout,
                LengthRule(editText,minLength,maxLength),message,key))

        /** Confirmation Rule register */
        fun confirmationRule(editText: EditText,confrimEditText: EditText,message: String,
                             key: String)
                = registerData.add(ValidationData1(editText,ConfirmationRule(editText,
                confrimEditText), message,key))
        fun confirmationRule(editText: EditText,confrimEditText: EditText,
                             textInputLayout: TextInputLayout, message: String,key: String)
                = registerData.add(ValidationData2(editText,textInputLayout,
                ConfirmationRule(editText,confrimEditText),message,key))

        /** Regex Rule register
         *
         ^                # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once you can replace with your special characters
        (?=\\S+$)         # no whitespace allowed in the entire string
        .{4,}             # anything, at least six places though
        $                 # end-of-string
         */
        fun regexRule(editText: EditText,regex:String,message: String,key: String)
                = registerData.add(ValidationData1(editText,RegexRule(editText,regex),message, key))
        fun regexRule(editText: EditText,textInputLayout: TextInputLayout,regex: String,message: String,
                     key: String)
                = registerData.add(ValidationData2(editText,textInputLayout,RegexRule(editText,regex),
                message,key))
    }


    /** Validation proses */
    fun validation(){
        startValidate()
        for (validator in registerData){
            when (validator){
                is ValidationData1 ->{
                    when(validator.method.validation()){
                        true ->{
                           data.put(validator.key,validator.method.getData()) }
                        false ->{
                            validator.editText.error = validator.message
                            errorCount++ }
                    }
                }
                is ValidationData2 ->{
                    when(validator.method.validation()){
                        true ->{
                            if(!findError(validator.textInputLayout)){
                                validator.textInputLayout.isErrorEnabled = false
                            }
                            data.put(validator.key,validator.method.getData())
                        }
                        false ->{
                            validator.textInputLayout.setErrorTextAppearance(R.style.text_error)

                            if(!findError(validator.textInputLayout)){
                                validator.textInputLayout.isErrorEnabled = true
                                validator.textInputLayout.error = validator.message
                            }

                            erorr.add(validator.textInputLayout)
                            errorCount++ }
                    }
                }
            }
        }
        finisValidate()
    }

    private fun startValidate(){
        errorCount = 0
        data.clear()
        erorr.clear()
    }

    private fun finisValidate(){
        when (errorCount){
            0 -> delegate.validationSuccess(data)
        }
    }

    private fun findError(textInputLayout: TextInputLayout):Boolean {
        val errorFind = erorr.contains(textInputLayout)

        return errorFind
    }







}