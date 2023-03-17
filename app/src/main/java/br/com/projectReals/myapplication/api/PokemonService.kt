package br.com.projectReals.myapplication.api

import br.com.projectReals.myapplication.api.model.PokemonApiResult
import br.com.projectReals.myapplication.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    //Fun de GETLIST, recebe lista
    @GET("pokemon")
    fun getListPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    //Função de GETBYID, recebe estrutura simples
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id")id: Int): Call<PokemonApiResult>
}