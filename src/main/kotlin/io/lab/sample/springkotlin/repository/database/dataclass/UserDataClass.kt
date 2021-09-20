package io.lab.sample.springkotlin.repository.database.dataclass

import io.lab.sample.springkotlin.repository.database.DatabaseContext
import javax.persistence.*

/***
 * Define the User fields.
 * If the 'name' parameter is omitted, a table will be created with de entity name
 */
@Entity
@Table(name = "User", schema = DatabaseContext.SCHEMA)
data class UserDataClass(
    @Column(name = "login") var login: String,
    var email:String,
    var firstname: String,
    var lastname: String,
    var description: String,
    @Id @GeneratedValue var id: Long
)


