package boraldan.rikkyandmorty.service;


import boraldan.rikkyandmorty.domen.Characters;
import boraldan.rikkyandmorty.domen.Result;

public interface ServiceApi {
    Characters getAllCharacters();
    Characters getAllCharacters(int page);
    Result getCharById(int id);

}
