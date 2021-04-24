package com.example.gdgsampleapp.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.work.*
import com.example.gdgsampleapp.databinding.ActivityMainBinding
import com.example.gdgsampleapp.model.ViewState
import com.example.gdgsampleapp.workamanger.UploadWorker

class SpaceNewsActivity : AppCompatActivity() {

    private val viewModel by viewModels<SpaceNewsActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.viewState.observe(this) {
            val progressBar = binding.progressBar
            when (it) {
                is ViewState.Complete -> progressBar.hide()
                is ViewState.Error -> {
                    progressBar.hide()
                    //TODO show error
                }
                is ViewState.Loading -> progressBar.show()
            }
        }

        val adapter = SpaceNewsRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.articlesLiveData.observe(this) {
            adapter.submitList(it)
        }
    }

    fun scheduleUploadJob() {

        val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true)
                .setRequiresBatteryNotLow(true)
                .build()


        val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
                        .setConstraints(constraints)
                        .build()

        WorkManager.getInstance(this)
                .enqueue(uploadWorkRequest)

    }
}