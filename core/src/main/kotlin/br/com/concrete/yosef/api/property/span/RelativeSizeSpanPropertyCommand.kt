package br.com.concrete.yosef.api.property.span

import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.View
import android.widget.TextView
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.entity.DynamicProperty

class RelativeSizeSpanPropertyCommand : DynamicPropertyCommand {

    companion object {
        const val SPAN_RELATIVE_SIZE = "spanRelativeSize"
    }

    override fun apply(view: View, dynamicProperty: DynamicProperty) {
        if (view !is TextView)
            throw IllegalArgumentException("Can't apply span on view ${view.javaClass.name}")

        val props = dynamicProperty.value.split(',')
        val start = props[0].toInt()
        val end = props[1].toInt()
        val multiplier = props[2].toFloat()

        val span = SpannableString(view.text)
        span.setSpan(RelativeSizeSpan(multiplier), start, end, 0)

        view.text = span
    }
}