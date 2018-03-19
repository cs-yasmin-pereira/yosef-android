package br.com.concrete.yosef.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import br.com.concrete.yosef.OnActionListener
import br.com.concrete.yosef.api.DynamicViewCreator

class RadioGroupActivity : AppCompatActivity(), OnActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json = MainActivity::class.java.getResource(
            "/assets/example_radiogroup.json").readText()

        val dynamicView = DynamicViewCreator.Builder().build()

        dynamicView.createViewFromJson(findViewById(R.id.parent), json, this)
    }

    override fun callAction(value: String) {
        findViewById<TextView>(R.id.textview).text = value
    }
}