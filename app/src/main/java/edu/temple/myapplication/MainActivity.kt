package edu.temple.myapplication

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var timerBinder: TimerService.TimerBinder
    var connected= true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceConnection = object :ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                timerBinder= service as TimerService.TimerBinder
                connected= true
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                connected= false
            }
        }

        bindService(Intent(this, TimerService::class.java), serviceConnection, BIND_AUTO_CREATE)

        findViewById<Button>(R.id.startButton).setOnClickListener {
            if(connected)
                timerBinder.start(50)
        }

        findViewById<Button>(R.id.pauseButton).setOnClickListener {
            if(connected)
                timerBinder.pause()
        }
        
        findViewById<Button>(R.id.stopButton).setOnClickListener {
            if(connected)
                timerBinder.stop()
        }
    }
}