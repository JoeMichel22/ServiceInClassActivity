package edu.temple.myapplication

import android.content.ComponentName
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var timerBinder: TimerService.TimerBinder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceConnection = object :ServiceConnection{
            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                timerBinder= service as TimerService.TimerBinder
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                TODO("Not yet implemented")
            }

            bindService(intent(this,TimerService::class.java))

        }

        findViewById<Button>(R.id.startButton).setOnClickListener {

        }

        findViewById<Button>(R.id.pauseButton).setOnClickListener {

        }
        
        findViewById<Button>(R.id.stopButton).setOnClickListener {

        }
    }
}