package io.lab.sample.springkotlin.repository.infrastructure.database.dataclass

import io.lab.sample.springkotlin.repository.infrastructure.database.DatabaseContext
import javax.persistence.*

/***
 * Define the User fields.
 * If the 'name' parameter is omitted, a table will be created with de entity name
 */
@Entity
@Table(name = "user", schema = DatabaseContext.SCHEMA)
data class UserRegister(
    @Column(name = "login") var login: String,
    var firstname: String,
    var lastname: String,
    var description: String,
    @Id @GeneratedValue var id: Long
)


