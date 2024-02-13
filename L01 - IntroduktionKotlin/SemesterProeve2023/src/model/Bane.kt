package model

import java.time.LocalDate
import java.time.LocalTime

class Bane(
    val nummer: Int,
    val inde: Boolean,
    val førsteTid: LocalTime,
    val sidsteTid: LocalTime,
    val Bane: Bane,
    val kategori: Kategori //link 0..* --> 1 Kategori
) {
    private val _bookings: MutableList<Booking> = mutableListOf()
        val bookings: List<Booking>
        get() = _bookings

    fun addBooking(booking: Booking) = _bookings.add(booking)
    fun removeBooking(booking: Booking) = _bookings.remove(booking)

    // S2
    fun bookedeTimerPåDato(dato: LocalDate): Int {
        var antalBookedeTimer = 0
        for (booking in bookings) {
            if (dato == booking.dato) {
                antalBookedeTimer++
            }
        }
        return antalBookedeTimer
    }

    fun bookedeTimerpåDato(dato : LocalDate): Int = bookings.count {dato == it.dato}

    //S4
    fun antalBookningerPrTime(): IntArray {
        val count = sidsteTid.hour - førsteTid.hour + 1
        val bookingCounts = IntArray(count)
        for (hour in førsteTid.hour .. sidsteTid.hour) {
            for (booking in bookings) {
                if (booking.tid.hour == hour) {
                    bookingCounts[hour - førsteTid.hour]++
                }
            }
        }
        return bookingCounts
    }

}