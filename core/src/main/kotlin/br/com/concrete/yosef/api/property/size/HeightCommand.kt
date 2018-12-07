package br.com.concrete.yosef.api.property.size

import android.view.View
import android.view.ViewGroup
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.dp
import br.com.concrete.yosef.entity.DynamicProperty

/**
 * Command class that implements the [DynamicPropertyCommand] applying
 * the height property to the view([View])
 */
class HeightCommand : DynamicPropertyCommand, DimenSpec {

    companion object {
        /**
         * This constant documents which name is associated with the property
         */
        const val HEIGHT_TYPE = "height"
    }

    override fun apply(view: View, dynamicProperty: DynamicProperty) {
        when (dynamicProperty.type) {
            dimenSpec -> applyDimenSpec(view, dynamicProperty)
            dimen -> view.layoutParams.height = dynamicProperty
                .value
                .toInt()
                .dp(view.context)
            else -> throw IllegalArgumentException("Can't apply ${dynamicProperty.name}" +
                    " with type ${dynamicProperty.type} and value ${dynamicProperty.value}.")
        }
    }

    override fun applyDimenSpec(view: View, dynamicProperty: DynamicProperty) {
        when (dynamicProperty.value) {
            match -> view.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            wrap -> view.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            else -> throw IllegalArgumentException(
                "Can't apply ${dynamicProperty.name}" +
                        " with value ${dynamicProperty.value}."
            )
        }
    }
}
