package com.mvvm.x930073498.mvvmrecyclerviewmodule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mvvm.x930073498.lib.base.startActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        startActivity<MainActivity>()
    }
}
