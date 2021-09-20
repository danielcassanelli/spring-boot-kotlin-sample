package io.lab.sample.springkotlin.repository.database

import io.lab.sample.springkotlin.repository.database.dataclass.UserDataClass
import io.lab.sample.springkotlin.repository.interfaces.IUserRepository
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserDataClassRepository : JpaRepository<UserDataClass?, Long?>, IUserRepository {
    fun existsByEmail(email: String?): Boolean
    fun findByEmail(email: String?): Optional<UserDataClass?>?
}