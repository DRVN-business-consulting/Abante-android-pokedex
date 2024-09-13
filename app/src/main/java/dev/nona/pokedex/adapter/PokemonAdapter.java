package dev.nona.pokedex.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.nona.pokedex.Dashboard;
import dev.nona.pokedex.R;
import dev.nona.pokedex.model.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemonList;

    public PokemonAdapter(List<Pokemon> pokemonList){
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pokemon_list, parent, false);
        PokemonViewHolder viewHolder = new PokemonViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(holder.getAdapterPosition());

        holder.bind(pokemon);


    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }


    class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView tvPokemonId;
        TextView tvPokemonName;
        TextView tvPokemonType;
        ImageView ivPokemonImg;
        LinearLayout list;

        public PokemonViewHolder (View itemView){
            super(itemView);
            tvPokemonId = itemView.findViewById(R.id.tvPokemonId);
            tvPokemonName = itemView.findViewById(R.id.tvPokemonName);
            tvPokemonType = itemView.findViewById(R.id.tvPokemonType);
            ivPokemonImg = itemView.findViewById(R.id.ivPokemonImg);
            list = itemView.findViewById(R.id.list);
        }

        public void bind(Pokemon pokemon){
            String[] pokemonType = pokemon.getPokemonType();
            String combinedTypes = String.join(", ", pokemonType);

            tvPokemonId.setText(String.valueOf(pokemon.getId()));
            tvPokemonName.setText(pokemon.getPokemonName());
            tvPokemonType.setText(combinedTypes);
            ivPokemonImg.setImageResource(pokemon.getPokemonImgUri());
            list.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), dev.nona.pokedex.Pokemon.class);
                intent.putExtra("pokemonId", pokemon.getId());

                view.getContext().startActivity(intent);
            });
        }
    }
}
