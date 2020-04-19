package com.github.dimanaux.wflux.services

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service("all")
class MergedJobsSources(val jobsServices: List<Jobs>) : Jobs {
    override fun toFlux() = Flux.merge(jobsServices.map(Jobs::toFlux))
}
