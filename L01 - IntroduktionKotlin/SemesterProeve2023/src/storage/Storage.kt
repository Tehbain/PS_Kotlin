package storage

import model.Bane
import model.Kategori
import model.Spiller

/*
Tilføj klassen Storage i pakken storage. Klassen skal indeholde lister med systemets spillere,
baner og kategorier. Klassen skal også indeholde metoder til at gemme objekter fra klasserne
Spiller, Bane og Kategori, og metoder til at hente alle spillere, baner og kategorier. Lav ikke
metoder til at slette objekterne fra Storage.
*/

class Storage {
    private val _listSpiller: MutableList<Spiller> = mutableListOf()
    val listSpiller: List<Spiller>
        get() = _listSpiller
        fun addSpiller(spiller: Spiller) = _listSpiller.add(spiller)
        fun removeSpiller(spiller: Spiller) = _listSpiller.remove(spiller)

    private val _listBane: MutableList<Bane> = mutableListOf()
    val listBane: List<Bane>
        get() = _listBane
        fun addBane(bane: Bane) = _listBane.add(bane)
        fun removeBane(bane: Bane) = _listBane.remove(bane)

    private val _listKategori: MutableList<Kategori> = mutableListOf()
    val listKategori: List<Kategori>
        get() = _listKategori
        fun addKategori(kategori: Kategori) = _listKategori.add(kategori)
        fun removeKategori(kategori: Kategori) = _listKategori.remove(kategori)
}