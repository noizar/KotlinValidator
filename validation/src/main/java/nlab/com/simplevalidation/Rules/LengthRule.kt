package nlab.com.simplevalidation.Rules

import android.widget.EditText
import nlab.com.simplevalidation.ValidationRules

/**
 * Created by noizar on 11/1/17.
 */
class LengthRule constructor(val editText: EditText,val minLength:Int,val maxLength:Int)
    :ValidationRules {
    override fun validation(): Boolean {
        return (editText.text.length in minLength..maxLength)
    }

    override fun getData(): String {
        return editText.text.toString()
    }


}