package com.mynotes.android.screens.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import com.mynotes.android.R as mainR

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainR.layout.activity_main)
    }
}