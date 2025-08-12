package com.example.komfplus

import com.example.komfplus.config.ApplicationConfig
import com.example.komfplus.infrastructure.http.HttpClient
import com.example.komfplus.infrastructure.persistence.Repository
import com.example.komfplus.infrastructure.schedulers.UpdateScheduler
import com.example.komfplus.presentation.cli.Commands

fun main() {
    val config = ApplicationConfig.load()
    val httpClient = HttpClient(config)
    val repository = Repository()
    val updateScheduler = UpdateScheduler(repository)

    // Initialize commands for CLI interaction
    val commands = Commands(repository, httpClient, updateScheduler)

    // Start the application
    commands.start()
}