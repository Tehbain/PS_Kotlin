package model

//da: Arrangement
class Event (
    val name: String,
    val isPublic: Boolean,

) {
    private val _reservations: MutableList<Reservation> = mutableListOf()
        val reservations: List<Reservation>
            get() = _reservations

    //S2: antalReserveredePladser()
    fun countReservedSeats(): Int {
        return reservations.sumOf { it.seats.size }
    }
}