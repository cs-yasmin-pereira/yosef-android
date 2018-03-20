package br.com.concrete.yosef.api.component

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import br.com.concrete.yosef.OnActionListener
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.api.property.id.IdCommand
import br.com.concrete.yosef.api.property.id.IdCommand.Companion.ID
import br.com.concrete.yosef.entity.DynamicProperty

/**
 * Class that implements the [Component] interface and creates the component
 * FrameComponent([FrameLayout]), applying its properties
 */
class FrameComponent : Component {

    companion object {
        /**
         * This constant documents which type is associated with the component
         */
        const val FRAME = "frame"
    }

    private val components: Map<String, DynamicPropertyCommand> = mapOf(
            ID to IdCommand()
    )

    override fun applyProperties(
            view: View,
            dynamicProperties: List<DynamicProperty>,
            actionListener: OnActionListener?
    ) {
        dynamicProperties.forEach {
            components[it.name]?.apply(view, it)
        }
    }

    override fun createView(parent: ViewGroup): View {
        return FrameLayout(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }
}