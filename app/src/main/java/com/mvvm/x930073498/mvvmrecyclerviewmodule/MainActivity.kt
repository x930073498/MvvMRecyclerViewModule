package com.mvvm.x930073498.mvvmrecyclerviewmodule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mvvm.x930073498.lib.base.BaseCallback
import com.mvvm.x930073498.lib.base.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseCallback.init(this)
        BaseCallback.open(this)
        BaseCallback.close(this)
        startActivity<SecondActivity>()
    }

    override fun onDestroy() {
        super.onDestroy()
        BaseCallback.destroy()
    }
}
