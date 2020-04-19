package com.github.dimanaux.wflux.services

import com.github.dimanaux.wflux.model.GitHubJob
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Component
class GitHubJobsApi : Jobs {
    private val client = WebClient.create("https://jobs.github.com/positions.json")

    override fun toFlux(): Flux<GitHubJob> = client.get()
            .accept(MediaType.APPLICATION_JSON).retrieve()
            .bodyToFlux(GitHubJob::class.java)
}
