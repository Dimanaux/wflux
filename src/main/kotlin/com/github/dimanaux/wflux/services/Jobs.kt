package com.github.dimanaux.wflux.services

import com.github.dimanaux.wflux.model.Job
import reactor.core.publisher.Flux

interface Jobs {
    fun toFlux(): Flux<out Job>
}
