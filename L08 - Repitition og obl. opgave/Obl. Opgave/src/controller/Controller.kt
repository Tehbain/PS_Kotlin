package controller

import model.AreaType
import model.Event
import model.Reservation
import storage.Storage
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


object Controller {
    val storage = Storage

    fun createEvent(name: String, isPublic: Boolean): Event {
        val event: Event = Event(name, isPublic)
        storage.addEvent(event)
        return event
    }

    fun createReservation(startDate: LocalDate, startTime: LocalTime, endDate: LocalDate, endTime: LocalTime): Reservation {
        val start = LocalDateTime(startDate, startTime)
        val end = LocalDateTime(endDate, endTime)

        val reservation = Reservation(start, end)
        storage.addReservation(reservation)
        return reservation
    }

    fun createSeat(number: Int, areaType: AreaType) {

    }
}