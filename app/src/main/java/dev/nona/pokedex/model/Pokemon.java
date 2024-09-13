package dev.nona.pokedex.model;

public class Pokemon {
    private int id;
    private String pokemonName;
    private String[] pokemonType;
    private int pokemonImgUri;


    public Pokemon(int id, String pokemonName, String[] pokemonType, int pokemonImgUri) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.pokemonImgUri = pokemonImgUri;
    }

    public int getId() {
        return id;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String[] getPokemonType() {
        return pokemonType;
    }

    public int getPokemonImgUri() {
        return pokemonImgUri;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setPokemonType(String[] pokemonType) {
        this.pokemonType = pokemonType;
    }

    public void setPokemonImgUri(int pokemonImgUri) {
        this.pokemonImgUri = pokemonImgUri;
    }
}

