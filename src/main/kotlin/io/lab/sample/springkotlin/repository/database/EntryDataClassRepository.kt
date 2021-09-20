package io.lab.sample.springkotlin.repository.database

import io.lab.sample.springkotlin.entities.EntryStatus
import io.lab.sample.springkotlin.entities.EntryType
import io.lab.sample.springkotlin.repository.database.dataclass.EntryDataClass
import io.lab.sample.springkotlin.repository.interfaces.IEntryRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.math.BigDecimal

/***
 * Note: be careful using @Query, the 'from' clause will not work
 * with a different table than EntryRegister.
 * You **have** to use the class name
 */
interface EntryDataClassRepository : JpaRepository<EntryDataClass, Long>, IEntryRepository {
    @Query(
        value = " select sum(l.value) from EntryDataClass l join l.user u "
                + " where u.id = :UserId and l.type =:type and l.status = :status group by u "
    )
    fun retrieveBalance(
        @Param("UserId") userId: Long,
        @Param("type") type: EntryType,
        @Param("status") status: EntryStatus
    ): BigDecimal
}