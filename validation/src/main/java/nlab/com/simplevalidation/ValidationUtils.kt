package nlab.com.simplevalidation

import android.support.design.widget.TextInputLayout
import android.widget.EditText

/**
 * Created by noizar on 11/1/17.
 */


interface ValidationDelegate{
    fun validationSuccess(data:HashMap<String,String>)
}

interface ValidationRules{
    fun validation():Boolean
    fun getData():String
}

data class ValidationData1(var editText: EditText,var method:ValidationRules,var message:String,
                           var key:String)
data class ValidationData2(var editText: EditText,var textInputLayout: TextInputLayout,
                           var method:ValidationRules,var message:String,var key:String)

data class ValidationError(var textInputLayout: TextInputLayout)

