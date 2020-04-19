package com.github.dimanaux.wflux.services

import com.github.dimanaux.wflux.model.DatabaseJob
import com.github.dimanaux.wflux.persistance.JobsRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class JobsFromDatabase(val jobsRepository: JobsRepository) : Jobs {
    override fun toFlux() = Flux.create<DatabaseJob> { sink ->
        paginate { sink.next(it) }
    }

    fun paginate(callback: (DatabaseJob) -> Unit) {
        var page = 0
        while (true) {
            val jobsPage = jobsRepository.findAll(PageRequest.of(page, 100))
            jobsPage.forEach(callback)
            page += 1
            if (jobsPage.isLast) return
        }
    }
}
