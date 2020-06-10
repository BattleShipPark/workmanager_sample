package com.battleshippark.workmanagersample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiresDeviceIdle(true)
            .build()

        val workRequest = PeriodicWorkRequestBuilder<HeavyWorker>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(
                "unique_heavy_work",
                ExistingPeriodicWorkPolicy.REPLACE,
                workRequest
            )
    }
}
