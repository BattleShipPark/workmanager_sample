package com.battleshippark.workmanagersample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class HeavyWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.i("HeavyWorker", "doing: $this")
        Thread.sleep(2000)
        Log.i("HeavyWorker", "done: $this")
        return Result.success()
    }

    override fun onStopped() {
        Log.i("HeavyWorker", "stopped: $this")
    }
}