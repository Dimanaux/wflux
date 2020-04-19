package com.github.dimanaux.wflux.model

import com.github.dimanaux.wflux.model.Job

data class GitHubJob(
        val id: String,
        override val type: String,
        val url: String,
        override val company: String,
        override val location: String,
        override val title: String,
        override val description: String
) : Job {
    override val jobId = id
    override val salary = "N/A"
    override val source = url
}
