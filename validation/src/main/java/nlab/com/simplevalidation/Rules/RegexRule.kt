package nlab.com.simplevalidation.Rules

import android.widget.EditText
import nlab.com.simplevalidation.ValidationRules
import java.util.regex.Pattern

/**
 * Created by noizar on 11/1/17.
 */
class RegexRule constructor(val editText: EditText,var regex:String): ValidationRules {
    override fun validation(): Boolean {
        return (Pattern.compile(regex).matcher(editText.text.toString()).find())
    }

    override fun getData(): String {
        return editText.text.toString()
    }

}