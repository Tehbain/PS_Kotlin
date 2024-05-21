package model

import java.time.LocalDateTime

//da: Reservation
class Reservation (
    val start: LocalDateTime,
    val end: LocalDateTime,
) {
    private val _events: MutableList<Event> = mutableListOf()
        val events: List<Event>
            get() = _events
    private val _seats: MutableList<Seat> = mutableListOf()
        val seats: List<Seat>
            get() = _seats
}