package com.cryptocon.cryptocon

import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.io.PrintWriter
import java.io.Writer
import java.lang.Exception
import java.net.Socket

class main : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val connect = findViewById<Button>(R.id.btn_connect)
        val btn_w = findViewById<Button>(R.id.btn_w)
        val btn_a = findViewById<Button>(R.id.btn_a)
        val btn_s = findViewById<Button>(R.id.btn_s)
        val btn_d = findViewById<Button>(R.id.btn_d)

        var outHandler = OutputHandler()
        outHandler.create()

        btn_w.setOnClickListener{
            System.out.println("pressed")
           outHandler.write("w")
        }
        btn_a.setOnClickListener {
            System.out.println("pressed")
            outHandler.write("w")
        }
        btn_s.setOnClickListener {
            System.out.println("pressed")
            outHandler.write("w")
        }
        btn_d.setOnClickListener {
            System.out.println("pressed")
            outHandler.write("w")
        }
        btn_w.rotation = -90f
        btn_a.rotation = -90f
        btn_s.rotation = -90f
        btn_d.rotation = -90f
        connect.rotation = -90f

    }
}
