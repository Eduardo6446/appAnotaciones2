package com.example.appanotaciones2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class NewTareaActivity : AppCompatActivity() {
    private lateinit var editTareaView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_tarea)
        val editAnotView = findViewById<TextView>(R.id.tvDescripcionTarea)

        val button = findViewById<Button>(R.id.btnAgregar)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editAnotView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val anot = editAnotView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, anot)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.anotlistsql.REPLY"
    }
}