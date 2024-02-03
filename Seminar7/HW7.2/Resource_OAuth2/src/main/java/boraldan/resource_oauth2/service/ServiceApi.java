package boraldan.resource_oauth2.service;


import boraldan.resource_oauth2.model.Characters;
import boraldan.resource_oauth2.model.Result;

public interface ServiceApi {
    Characters getAllCharacters();
    Characters getAllCharacters(int page);
    Result getCharById(int id);

}
