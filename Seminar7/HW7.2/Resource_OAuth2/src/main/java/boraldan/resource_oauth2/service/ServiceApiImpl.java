package boraldan.resource_oauth2.service;

import boraldan.resource_oauth2.api.Url;
import boraldan.resource_oauth2.model.Characters;
import boraldan.resource_oauth2.model.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceApiImpl implements ServiceApi {

    private RestTemplate template;
    private HttpHeaders headers;
    private final Url URL;

    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(URL.getCHARACTER_API(), HttpMethod.GET, entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Characters getAllCharacters(int page) {
        String urlPage = "?page=" + page;
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(URL.getCHARACTER_API() + urlPage, HttpMethod.GET, entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Result getCharById(int id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> responce = template.exchange(URL.getCHAR_ID_API().formatted(id),
                HttpMethod.GET, entity, Result.class);
        return responce.getBody();
    }
}
