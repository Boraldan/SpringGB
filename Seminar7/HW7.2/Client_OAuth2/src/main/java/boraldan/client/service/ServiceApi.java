package boraldan.client.service;


import boraldan.client.model.Characters;
import boraldan.client.model.Result;
import org.springframework.http.HttpHeaders;

public interface ServiceApi {
    Characters getAllCharacters(HttpHeaders headers);
    Characters getAllCharacters(HttpHeaders headers, int page);
    Result getCharById(HttpHeaders headers, int id);

}
