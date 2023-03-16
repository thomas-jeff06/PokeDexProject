package br.com.projectReals.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.projectReals.myapplication.R
import br.com.projectReals.myapplication.api.PokemonRepository
import br.com.projectReals.myapplication.api.model.PokemonApiResult
import br.com.projectReals.myapplication.api.viewModel.PokemonViewModel
import br.com.projectReals.myapplication.api.viewModel.PokemonViewModelFactory
import br.com.projectReals.myapplication.domain.Pokemon
import br.com.projectReals.myapplication.domain.PokemonType

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvPokedex)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}
