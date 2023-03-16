package br.com.projectReals.myapplication.api.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.projectReals.myapplication.api.PokemonRepository
import br.com.projectReals.myapplication.domain.Pokemon

class PokemonViewModel : ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon?>>()

    init {
        Thread(Runnable
        {
            loadPokemons();
        }).start()
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.getListPokemons()

        pokemonsApiResult?.results?.let {
            pokemons.postValue(it.map { pokemonResult ->
                val parameterId = pokemonResult.url
                    .replace("https://pokeapi.con/api/v2/pokemon/", "")
                    .replace("/", "").toLong()

                val pokemonApiResult = PokemonRepository.getPokemonById(parameterId)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map{ type ->
                            type.type
                        }
                    )
                }
            }
        )}
    }
}