package boraldan.client.controller;

import boraldan.client.model.Characters;
import boraldan.client.service.HeaderService;
import boraldan.client.service.ServiceApi;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Base64;

/**

 * Контроллер клиента. Заходить на http://127.0.0.1:8080/
 */
@Controller
@AllArgsConstructor
public class ClientController {
    //  Объект для получения токена авторизации.
    private final OAuth2AuthorizedClientService authorizedClientService;
    private HttpHeaders headers;
    private final ServiceApi serviceApi;
    private final HeaderService headerService;

    @GetMapping
    public String getCharacters(Model model, @RequestParam(value = "page", required = false) Integer pageNumber,
                                Principal principal) {
        // Получение access токена. Создаем заголовок и помещаем в него токен авторизации
        headers = headerService.addAuthHeader(principal);
        if (pageNumber == null) {
            Characters allCharacters = serviceApi.getAllCharacters(headers);
            model.addAttribute("characters", allCharacters.getResults());
            model.addAttribute("info", allCharacters.getInfo());
            model.addAttribute("currentPage", 5);
        } else {
            Characters allCharacters = serviceApi.getAllCharacters(headers, pageNumber);
            model.addAttribute("characters", allCharacters.getResults());
            model.addAttribute("info", allCharacters.getInfo());
            model.addAttribute("currentPage", pageNumber);
        }
        return "index";
    }

    @GetMapping("/{id}")
    public String getChar(Model model, @PathVariable("id") int id, Principal principal) {
        // Получение access токена. Создаем заголовок и помещаем в него токен авторизации
        headers = headerService.addAuthHeader(principal);
        model.addAttribute("chars", serviceApi.getCharById(headers, id));
        return "character";
    }
}
