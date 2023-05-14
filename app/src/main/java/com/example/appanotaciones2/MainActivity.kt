package com.example.appanotaciones2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appanotaciones2.model.Anotacion
import com.example.appanotaciones2.AnotViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val NewAnotActivityRequestCode = 1
    private val anotViewModel: AnotViewModel by viewModels {
        AnotViewModelFactory((application as AnotApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = AnotListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        /*AnotViewModel.allWords.observe(owner = this) { anot ->
            // Update the cached copy of the words in the adapter.
            anot.let { adapter.submitList(it) }
        }*/





        val fab = findViewById<Button>(R.id.btnAgregar)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewTareaActivity::class.java)
            startActivityForResult(intent, NewAnotActivityRequestCode)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)
        var id:Long = 1
        if (requestCode == NewAnotActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewTareaActivity.EXTRA_REPLY)?.let { reply ->
                val anot = Anotacion(id,reply ,Finalizado = true)
                anotViewModel.insert(anot)
            }
            id++
        } else {
            Toast.makeText(
                applicationContext,
                R.string.strValidacionError,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}