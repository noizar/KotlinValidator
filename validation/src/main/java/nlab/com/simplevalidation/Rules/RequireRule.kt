package nlab.com.simplevalidation.Rules

import android.widget.EditText
import nlab.com.simplevalidation.ValidationRules

/**
 * Created by noizar on 11/1/17.
 */
class RequireRule constructor(val editText: EditText): ValidationRules {
    override fun validation(): Boolean {
        return (editText.text.isNotEmpty())
    }

    override fun getData(): String {
        return  editText.text.toString()
    }

}