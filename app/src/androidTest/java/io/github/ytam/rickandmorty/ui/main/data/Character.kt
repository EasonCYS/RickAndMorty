package io.github.ytam.rickandmorty.ui.main.data

data class Character(
    var id: Int?,
    var name: String,
    var status: String?,
    var species: String?,
    var gender: String?,
    var origin: String?,
    var location: String?,
    var episode: String?) {

    constructor() :
            this(Int.MIN_VALUE, "rick", "","", "", "", "", "")
}
