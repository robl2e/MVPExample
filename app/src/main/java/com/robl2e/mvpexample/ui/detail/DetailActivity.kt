package com.robl2e.mvpexample.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robl2e.mvpexample.R

class DetailActivity : AppCompatActivity() {
    private lateinit var detailComponent: DetailComponent

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_frame)
        detailComponent = DetailComponent(findViewById(R.id.content_view))
        lifecycle.addObserver(detailComponent)
    }
}