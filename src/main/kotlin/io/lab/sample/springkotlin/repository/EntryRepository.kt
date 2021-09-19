package io.lab.sample.springkotlin.repository

import io.lab.sample.springkotlin.model.EntryStatus
import io.lab.sample.springkotlin.model.EntryType
import io.lab.sample.springkotlin.repository.infrastructure.database.dataclass.EntryRegister
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.math.BigDecimal

interface EntryRepository : JpaRepository<EntryRegister?, Long?> {
    @Query(
        value = " select sum(l.value) from entry l join l.user u "
                + " where u.id = :UserId and l.type =:type and l.status = :status group by u "
    )
    fun retrieveBalance(
        @Param("UserId") userId: Long,
        @Param("type") type: EntryType,
        @Param("status") status: EntryStatus
    ): BigDecimal?
}