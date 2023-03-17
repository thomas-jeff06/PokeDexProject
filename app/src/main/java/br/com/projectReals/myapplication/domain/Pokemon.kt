package br.com.projectReals.myapplication.domain

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<PokemonType>
){
    val formattedName = name.capitalize()

    val formattedNumber = id.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}
