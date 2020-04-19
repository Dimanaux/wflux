package com.github.dimanaux.wflux.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class DatabaseJob(
        @Id
        @GeneratedValue
        var id: Int?,
        override var title: String,
        override var description: String,
        override var location: String,
        override var company: String,
        var payRate: Int,
        var hoursPerWeek: Int
) : Job {
    override val jobId = id.toString()
    override val type = if (hoursPerWeek < 30) "Part-Time" else "Full-Time"
    override val salary = (payRate * hoursPerWeek).toString() + " per week"
    override val source = "It is fake from database"
}
