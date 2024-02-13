package model

import java.time.LocalDate
import java.time.LocalTime

class Booking(
    val dato: LocalDate,
    val tid: LocalTime,
    val single: Boolean,
    val spiller: Spiller, //link 0..* Spiller
    val bane: Bane //link 0..* Bane
) {
}