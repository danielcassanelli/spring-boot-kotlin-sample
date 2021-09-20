package io.lab.sample.springkotlin.repository.database.dataclass

import io.lab.sample.springkotlin.entities.EntryStatus
import io.lab.sample.springkotlin.entities.EntryType
import io.lab.sample.springkotlin.repository.database.DatabaseContext
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "Entry", schema = DatabaseContext.SCHEMA)
data class EntryDataClass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id: Long? = null,

    @Column(name = "description")
    private val description: String? = null,

    @Column(name = "month")
    private val month: Int? = null,

    @Column(name = "year")
    private val year: Int? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    private val user: UserDataClass? = null,

    @Column(name = "value")
    private val value: BigDecimal? = null,

    @Column(name = "registration_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter::class)
    private val registrationDate: LocalDate? = null,

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private val type: EntryType? = null,

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private val status: EntryStatus? = null
)