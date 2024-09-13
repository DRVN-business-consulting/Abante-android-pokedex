package dev.nona.pokedex;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Pokemon extends AppCompatActivity {

    ImageView ivPokemonImg;
    TextView tvPokemonId;
    TextView tvPokemonName;
    TextView tvPokemonType;

    List<dev.nona.pokedex.model.Pokemon> pokemonList = List.of(
            new dev.nona.pokedex.model.Pokemon(1, "Pikachu", new String[]{"Electric"}, R.drawable.pikachu),
            new dev.nona.pokedex.model.Pokemon(2, "Bulbasaur", new String[]{"Grass", "Poison"}, R.drawable.bulbasaur),
            new dev.nona.pokedex.model.Pokemon(3, "Charmander", new String[]{"Fire"}, R.drawable.charmander),
            new dev.nona.pokedex.model.Pokemon(4, "Squirtle", new String[]{"Water"}, R.drawable.squirtle),
            new dev.nona.pokedex.model.Pokemon(5, "Caterpie", new String[]{"Bug"}, R.drawable.caterpie),
            new dev.nona.pokedex.model.Pokemon(6, "Weedle", new String[]{"Bug", "Poison"}, R.drawable.weedle),
            new dev.nona.pokedex.model.Pokemon(7, "Pidgey", new String[]{"Normal", "Flying"}, R.drawable.pidgey),
            new dev.nona.pokedex.model.Pokemon(8, "Rattata", new String[]{"Normal"}, R.drawable.rattata),
            new dev.nona.pokedex.model.Pokemon(9, "Spearow", new String[]{"Normal", "Flying"}, R.drawable.spearow),
            new dev.nona.pokedex.model.Pokemon(10, "Ekans", new String[]{"Poison"}, R.drawable.ekans)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivPokemonImg = findViewById(R.id.ivPokemonImg);
        tvPokemonId = findViewById(R.id.tvPokemonId);
        tvPokemonName = findViewById(R.id.tvPokemonName);
        tvPokemonType = findViewById(R.id.tvPokemonType);

        int pokemonId = getIntent().getIntExtra("pokemonId", 0);

        dev.nona.pokedex.model.Pokemon selectedPokemon = null;
        for (dev.nona.pokedex.model.Pokemon pokemon : pokemonList) {
            if (pokemon.getId() == pokemonId) {
                selectedPokemon = pokemon;
                break;
            }
        }


        String[] pokemonType = selectedPokemon.getPokemonType();
        String combinedTypes = String.join(", ", pokemonType);


        ivPokemonImg.setImageResource(selectedPokemon.getPokemonImgUri());
        tvPokemonId.setText(String.valueOf(selectedPokemon.getId()));
        tvPokemonName.setText(selectedPokemon.getPokemonName());
        tvPokemonType.setText(combinedTypes);

    }

    public void backToDashboard(View view) {
        finish();
    }
}