package br.com.projectReals.myapplication.api

import br.com.projectReals.myapplication.api.model.PokemonApiResult
import br.com.projectReals.myapplication.api.model.PokemonsApiResult
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {

    private val service: PokemonService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun getListPokemons(limit: Int = 151): PokemonsApiResult?
    {
        val call = service.getListPokemons(limit)

        return call.execute().body()
    }

    fun getPokemonById(id: Int): PokemonApiResult?
    {
        val call = service.getPokemon(id)

        return call.execute().body()
    }
}