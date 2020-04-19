package com.github.dimanaux.wflux.model

interface Job {
    val jobId: String
    val title: String
    val description: String
    val location: String
    val company: String
    val type: String
    val salary: String
    val source: String
}
