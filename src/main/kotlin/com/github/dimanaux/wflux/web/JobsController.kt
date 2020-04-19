package com.github.dimanaux.wflux.web

import com.github.dimanaux.wflux.services.Jobs
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/jobs")
class JobsController(@Qualifier("all") val jobs: Jobs) {
    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun index() = jobs.toFlux()
}
