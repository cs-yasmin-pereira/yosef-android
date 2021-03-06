package br.com.concrete.yosef.canarinho.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import br.com.concrete.yosef.OnActionListener
import br.com.concrete.yosef.api.DynamicViewCreator
import br.com.concrete.yosef.canarinho.api.component.CanarinhoTextFieldComponent
import br.com.concrete.yosef.canarinho.api.component.CanarinhoTextFieldComponent.Companion.TEXT_FIELD
import br.com.concrete.yosef.canarinho.test.R

class TextFieldActivity : AppCompatActivity(), OnActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val json = TextFieldActivity::class.java
            .getResource("/assets/example_textfield.json").readText()

        val dynamicView = DynamicViewCreator.Builder()
            .addComponentFor(TEXT_FIELD, CanarinhoTextFieldComponent())
            .build()

        setContentView(dynamicView.createViewFromJson(this, json, this))
    }

    override fun callAction(value: String) {
        findViewById<TextView>(R.id.textview).text = value
    }
}
