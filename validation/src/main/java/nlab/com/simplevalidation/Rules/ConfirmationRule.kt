package nlab.com.simplevalidation.Rules

import android.widget.EditText
import nlab.com.simplevalidation.ValidationRules

/**
 * Created by noizar on 11/1/17.
 */
class ConfirmationRule constructor(val editText: EditText, val confirmField:EditText)
    : ValidationRules {

    override fun validation(): Boolean {
        return (confirmField.text.toString() ==  editText.text.toString())
    }

    override fun getData(): String {
        return  editText.text.toString()
    }
}