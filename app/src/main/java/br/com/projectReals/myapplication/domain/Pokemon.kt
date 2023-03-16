package br.com.projectReals.myapplication.domain

data class Pokemon(
    val pokemonId: Long,
    val name: String,
    val types: List<PokemonType>
){
    val formattedName = name.capitalize()

    val formattedNumber = pokemonId.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}
