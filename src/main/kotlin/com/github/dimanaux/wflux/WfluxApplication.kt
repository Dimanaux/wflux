package com.github.dimanaux.wflux

import com.github.dimanaux.wflux.persistance.DatabaseFaker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WfluxApplication

fun main(args: Array<String>) {
    val application = runApplication<WfluxApplication>(*args)
    val databaseFaker = application.getBean(DatabaseFaker::class.java)
    if (!databaseFaker.fakedAlready()) {
        databaseFaker.fake(100_000)
    }
}
