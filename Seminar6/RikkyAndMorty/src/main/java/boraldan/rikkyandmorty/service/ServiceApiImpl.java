package boraldan.rikkyandmorty.service;


import boraldan.rikkyandmorty.api.Url;
import boraldan.rikkyandmorty.domen.Characters;
import boraldan.rikkyandmorty.domen.Result;
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
    private Url url;


    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(url.getCHARACTER_API(), HttpMethod.GET, entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Characters getAllCharacters(int page) {
        String urlPage = "?page=" + page;
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(url.getCHARACTER_API() + urlPage, HttpMethod.GET, entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Result getCharById(int id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> responce = template.exchange(url.getCHAR_ID_API().formatted(id),
                HttpMethod.GET, entity, Result.class);
        return responce.getBody();
    }
}