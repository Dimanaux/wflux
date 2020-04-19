package com.github.dimanaux.wflux.persistance

import com.github.dimanaux.wflux.model.DatabaseJob
import org.springframework.stereotype.Component

@Component
class DatabaseFaker(private val repository: JobsRepository) {
    fun fake(count: Int) {
        repository.saveAll(
                generateSequence(1, Int::inc)
                        .map(this::fakeJob)
                        .take(count)
                        .asIterable()
        )
    }

    fun fakedAlready() = repository.count() > 0

    private fun fakeJob(number: Int) = DatabaseJob(
            number,
            "Java Developer #$number",
            "Java developer on Spring stack #$number",
            "Default City",
            "Startup #$number",
            15 + number % 100,
            20 + number % 20
    )
}
