package br.com.projectReals.myapplication.api.model

import br.com.projectReals.myapplication.domain.PokemonType

data class PokemonsApisResults (
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult (
        val name: String,
        val url: String
)

data class PokemonApiResult(
    val id: Long,
    val name: String,
    val types: List<PokemonTypeSlot>
)
data class PokemonTypeSlot(
    val slot: Long,
    val type: PokemonType
)
