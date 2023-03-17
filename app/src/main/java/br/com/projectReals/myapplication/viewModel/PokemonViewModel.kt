package br.com.projectReals.myapplication.viewModel

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
                val id = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult = PokemonRepository.getPokemonById(id)

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