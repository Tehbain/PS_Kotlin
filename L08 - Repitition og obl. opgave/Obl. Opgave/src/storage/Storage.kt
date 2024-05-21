package storage

import model.Event
import model.Reservation
import model.Seat

object Storage {
    private val _events: MutableList<Event> = mutableListOf()
        val events: List<Event>
            get() = _events

    private val _reservations: MutableList<Reservation> = mutableListOf()
        val reservations: List<Reservation>
            get() = _reservations

    private val _seats: MutableList<Seat> = mutableListOf()
        val reservation: List<Seat>
            get() = _seats

    fun addEvent(event: Event) {
        _events.add(event)
    }

    fun addReservation(reservation: Reservation) {
        _reservations.add(reservation)
    }

    fun addSeat(seat: Seat) {
        _seats.add(seat)
    }
}