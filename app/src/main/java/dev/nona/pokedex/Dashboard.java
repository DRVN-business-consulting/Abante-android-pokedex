package dev.nona.pokedex;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.nona.pokedex.adapter.PokemonAdapter;
import dev.nona.pokedex.model.Pokemon;

public class Dashboard extends AppCompatActivity {

    RecyclerView recyclerView;
    PokemonAdapter adapter;

    List<Pokemon> pokemonList = List.of(
            new Pokemon(1, "Pikachu", new String[]{"Electric"}, R.drawable.pikachu),
            new Pokemon(2, "Bulbasaur", new String[]{"Grass", "Poison"}, R.drawable.bulbasaur),
            new Pokemon(3, "Charmander", new String[]{"Fire"}, R.drawable.charmander),
            new Pokemon(4, "Squirtle", new String[]{"Water"}, R.drawable.squirtle),
            new Pokemon(5, "Caterpie", new String[]{"Bug"}, R.drawable.caterpie),
            new Pokemon(6, "Weedle", new String[]{"Bug", "Poison"}, R.drawable.weedle),
            new Pokemon(7, "Pidgey", new String[]{"Normal", "Flying"}, R.drawable.pidgey),
            new Pokemon(8, "Rattata", new String[]{"Normal"}, R.drawable.rattata),
            new Pokemon(9, "Spearow", new String[]{"Normal", "Flying"}, R.drawable.spearow),
            new Pokemon(10, "Ekans", new String[]{"Poison"}, R.drawable.ekans)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.rvpokemonList);
        adapter = new PokemonAdapter(pokemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}