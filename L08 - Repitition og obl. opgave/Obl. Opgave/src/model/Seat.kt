package model


//da: Plads
open class Seat(
    val number: Int,
    val areaType: AreaType
) {

    private val _reservations: MutableList<Reservation> = mutableListOf()
    val reservations: List<Reservation> get() = _reservations
    companion object defaultHourlyPrice {
        private var price: Double = 50.0
        fun getPrice(): Double {return price}
        fun setPrice(price: Double) {this.price = price}
    }

    open fun price(hours: Int): Double {
        fun discount(price: Double, discount: Double): Double {
            return price * (1 + discount)
        }

        val price = when (areaType) {
            AreaType.STANDART -> getPrice()
            AreaType.VIP -> discount(getPrice(), 0.25)
            AreaType.CHILD -> discount(getPrice(), -0.20)
            AreaType.TOURNAMENT -> discount(getPrice(), 0.20)
        }
        return price
    }
}

//da: KonsolPlads
class ConsoleSeat(number: Int, val type: String, areaType: AreaType) : Seat(number, areaType) {
    override fun price(hours: Int): Double {
        fun discount(price: Double, discount: Double): Double {
            var premium = 0.25
            if (areaType == AreaType.CHILD) {
                premium = 0.10
            }
            return price * (1 + (discount + premium))
        }

        val price = when (areaType) {
            AreaType.STANDART -> getPrice()
            AreaType.VIP -> discount(getPrice(), 0.25)
            AreaType.CHILD -> discount(getPrice(), -0.20)
            AreaType.TOURNAMENT -> discount(getPrice(), 0.20)
        }
        return price
    }
}

