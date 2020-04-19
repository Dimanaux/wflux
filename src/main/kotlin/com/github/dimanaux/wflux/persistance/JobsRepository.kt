package com.github.dimanaux.wflux.persistance

import com.github.dimanaux.wflux.model.DatabaseJob
import org.springframework.data.jpa.repository.JpaRepository

interface JobsRepository : JpaRepository<DatabaseJob, Int> {
}
