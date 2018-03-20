package br.com.concrete.yosef.api.property.span

import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import br.com.concrete.yosef.OnActionListener
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.entity.DynamicProperty

class ClickableSpanPropertyCommand : DynamicPropertyCommand {

    companion object {
        const val SPAN_CLICKABLE = "spanClickable"
    }

    var actionListener: OnActionListener? = null

    override fun apply(view: View, dynamicProperty: DynamicProperty) {
        if (view !is TextView)
            throw IllegalArgumentException("Can't apply span on view ${view.javaClass.name}")

        view.movementMethod = LinkMovementMethod.getInstance()

        val props = dynamicProperty.value.split(',')
        val start = props[0].toInt()
        val end = props[1].toInt()
        val action = props[2]

        val span = SpannableString(view.text)
        span.setSpan(object : ClickableSpan() {
            override fun onClick(p0: View?) {
                actionListener?.callAction(action)
            }

            override fun updateDrawState(ds: TextPaint?) {
            }
        }, start, end, 0)

        view.text = span
    }
}