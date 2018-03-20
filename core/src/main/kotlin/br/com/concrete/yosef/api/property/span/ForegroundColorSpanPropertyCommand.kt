package br.com.concrete.yosef.api.property.span

import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.entity.DynamicProperty

class ForegroundColorSpanPropertyCommand : DynamicPropertyCommand {

    companion object {
        const val SPAN_FG_COLOR = "spanFgColor"
    }

    override fun apply(view: View, dynamicProperty: DynamicProperty) {
        if (view !is TextView)
            throw IllegalArgumentException("Can't apply span on view ${view.javaClass.name}")

        val props = dynamicProperty.value.split(',')
        val start = props[0].toInt()
        val end = props[1].toInt()
        val color = Color.parseColor(props[2])

        val span = SpannableString(view.text)
        span.setSpan(ForegroundColorSpan(color), start, end, 0)

        view.text = span
    }
}