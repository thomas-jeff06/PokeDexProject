package br.com.projectReals.myapplication.api

import android.util.Log
import br.com.projectReals.myapplication.api.model.PokemonApiResult
import br.com.projectReals.myapplication.api.model.PokemonsApisResults
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {

    private val service: PokemonService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.con/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun getListPokemons(limit: Int = 151): PokemonsApisResults?
    {
        val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemonById(PokemonId: Long): PokemonApiResult?
    {
        val call = service.getPokemon(PokemonId)

        return call.execute().body()
    }


    //https://pokeapi.con/api/v2/pokemon/?limit=151
}