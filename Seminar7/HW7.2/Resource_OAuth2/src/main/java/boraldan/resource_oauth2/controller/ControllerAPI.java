package boraldan.resource_oauth2.controller;


import boraldan.resource_oauth2.service.ServiceApi;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@AllArgsConstructor
@RequestMapping("/api/character")
public class ControllerAPI {

    private ServiceApi serviceApi;
    /**
     * @param pageNumber Номер страницы в списке пагинации
     * @return все персонажи
     */
    @GetMapping
    public ResponseEntity<?> getCharacters(@RequestParam(value = "page", required = false) Integer pageNumber) {
        if (pageNumber == null) return ResponseEntity.ok(serviceApi.getAllCharacters());
        return ResponseEntity.ok(serviceApi.getAllCharacters(pageNumber));
    }

    /**
     * @param id персонажа
     * @return страница персонажа
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getChar(@PathVariable("id") int id) {
        return ResponseEntity.ok(serviceApi.getCharById(id));

    }

}
