package model

class Spiller(
    val navn: String,
    val uddannelse: String
) {
    //link 1 --- 0..* Booking
    private val _bookings: MutableList<Booking> = mutableListOf()
    val bookings: List<Booking>
        get() = _bookings

    //S3

    fun samletPris(kategori: Kategori): Double {
        var samletKatPris = 0.0;
        for (booking in bookings) {
            with(booking) {
            if (kategori == bane.kategori) {
                samletKatPris += if (single) {
                    bane.kategori.prisKrSingle
                } else
                    bane.kategori.prisKrDouble
                }
            }
        }
        return samletKatPris;
    }
}