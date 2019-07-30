package com.littlecorgi.androidcomponentialprogramming

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/app/MainActivity")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }
}
