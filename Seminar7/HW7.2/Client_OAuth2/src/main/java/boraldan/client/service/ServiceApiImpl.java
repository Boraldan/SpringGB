package boraldan.client.service;



import boraldan.client.api.Url;
import boraldan.client.model.Characters;
import boraldan.client.model.Result;
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
    public Characters getAllCharacters(HttpHeaders headers) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(URL.getCHARACTER_API(), HttpMethod.GET, entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Characters getAllCharacters(HttpHeaders headers, int page) {
        String urlPage = "?page=" + page;
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(URL.getCHARACTER_API() + urlPage, HttpMethod.GET, entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Result getCharById(HttpHeaders headers, int id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> responce = template.exchange(URL.getCHAR_ID_API().formatted(id),
                HttpMethod.GET, entity, Result.class);
        return responce.getBody();
    }
}
