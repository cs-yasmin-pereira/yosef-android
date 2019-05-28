package br.com.concrete.yosef.api.property.text

import android.view.Gravity
import android.view.View
import android.widget.TextView
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.entity.DynamicProperty

/**
 * Command class that implements the [DynamicPropertyCommand] applying
 * the textAlignment property to the view([TextView])
 *
 * @see [TextView.setGravity]
 */
class TextAlignmentCommand : DynamicPropertyCommand {

    companion object {
        /**
         * This constant documents which name is associated with the property
         */
        const val TEXT_ALIGNMENT = "textAlignment"
    }

    override fun apply(view: View, dynamicProperty: DynamicProperty) {
        if (view is TextView) {
            view.gravity = when (dynamicProperty.value.toLowerCase()) {
                "left" -> Gravity.START
                "right" -> Gravity.END
                "center" -> Gravity.CENTER
                "top" -> Gravity.TOP
                "bottom" -> Gravity.BOTTOM
                else -> {
                    throw IllegalArgumentException(
                        "The value(${dynamicProperty.value}) " +
                            "for the $TEXT_ALIGNMENT property does not exist or is not supported"
                    )
                }
            }
            return
        }
        throw IllegalArgumentException(
            "The value (${dynamicProperty.value}) " +
                "for the $TEXT_ALIGNMENT property is not compatible with ${view.javaClass.name}"
        )
    }
}