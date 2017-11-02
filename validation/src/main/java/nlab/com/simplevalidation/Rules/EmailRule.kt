package nlab.com.simplevalidation.Rules

import android.util.Patterns
import android.widget.EditText
import nlab.com.simplevalidation.ValidationRules

/**
 * Created by noizar on 11/1/17.
 */
class EmailRule constructor(var editText: EditText):ValidationRules {
    override fun validation(): Boolean {
        return ( Patterns.EMAIL_ADDRESS.matcher(editText.text.toString()).matches())
    }

    override fun getData(): String {
        return editText.text.toString()
    }

}