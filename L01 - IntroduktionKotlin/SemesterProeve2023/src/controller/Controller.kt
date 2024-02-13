package controller

import model.Bane
import model.Booking
import model.Kategori
import model.Spiller
import java.time.LocalDate
import java.time.LocalTime

/*
Tilføj klassen Controller i pakken controller. Klassen skal indeholde metoder til at oprette
systemets objekter.
Tilføj klassen App med en main() metode i pakken gui. Klassen skal have en metode
initStorage(), der under anvendelse af opret-metoderne opretter og gemmer data svarende til
nedenstående:

Kategorier:
    Navn: Luksus Single/double pris: 100/200 kr.
    Navn: Mellem Single/double pris: 50/100 kr.
    Navn: Begynder Single/double pris: 25/50 kr.
Baner:
    Der er 6 baner med numrene 1-6. Bane 1-3 er indendørs og bane 4-6 er udendørs.
    Alle baner kan bookes fra kl. 9 til kl. 17. Bane 1 og 2 er Luksus baner, bane 3 og 4 er
    Mellem baner, og bane 5 og 6 er Begynder baner.
Spillere: Navn: Andreas Uddannelse: DMU
    Navn: Petra Uddannelse: DMU
    Navn: Henrik Uddannelse: ITA
    Navn: Ulla Uddannelse: ITA
Bookinger:
    Andreas har booket bane 3 den 20/6-23 kl. 10 til single spil
    og bane 2 den 22/6-23 kl. 10 til doublespil.
    Henrik har booket bane 3 den 20/6-23 kl. 11 til double spil.
    Ulla har booket bane 3 den 20/6-23 kl. 16. til double spil
    og bane 5 den 23/6-23 kl. 17 til single spil.
 */

object Controller {

    fun createKategori(navn: String, prisSingle: Int, prisDouble: Int): Kategori {
        return Kategori(navn, prisSingle.toDouble(), prisDouble.toDouble())
    }

    fun createSpiller(navn: String, uddannelse: String): Spiller{
        return Spiller(navn, uddannelse)
    }

    fun createBooking(dato: LocalDate, tid:LocalTime, erSingle: Boolean, spiller: Spiller, bane: Bane): Booking {
        return Booking(dato, tid, erSingle, spiller, bane)
    }
}