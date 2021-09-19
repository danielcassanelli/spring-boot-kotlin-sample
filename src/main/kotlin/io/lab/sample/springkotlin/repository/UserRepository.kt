package io.lab.sample.springkotlin.repository

import io.lab.sample.springkotlin.repository.infrastructure.database.dataclass.UserRegister
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<UserRegister?, Long?> {
    fun existsByEmail(email: String?): Boolean
    fun findByEmail(email: String?): Optional<UserRegister?>?
}