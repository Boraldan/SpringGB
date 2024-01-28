package boraldan.rikkyandmorty.controller;

import boraldan.rikkyandmorty.domen.Characters;
import boraldan.rikkyandmorty.service.ServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/character")
public class ControllerAPI {

    private ServiceApi serviceApi;

//    @GetMapping
//    public ResponseEntity<Characters> getCharacters() {
//        Characters allCharacters = serviceApi.getAllCharacters();
//        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
//    }

    /**
     * @param pageNumber Номер страницы в списке пагинации
     * @return все персонажи
     */
    @GetMapping
    public String getCharacters(Model model, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        if (pageNumber == null) {
            Characters allCharacters = serviceApi.getAllCharacters();
            int currentPage = 5;
            model.addAttribute("characters", allCharacters.getResults());
            model.addAttribute("info", allCharacters.getInfo());
            model.addAttribute("currentPage", currentPage);
        } else {
            Characters allCharacters = serviceApi.getAllCharacters(pageNumber);
            int currentPage = pageNumber;
            model.addAttribute("characters", allCharacters.getResults());
            model.addAttribute("info", allCharacters.getInfo());
            model.addAttribute("currentPage", currentPage);
        }
        return "index";
    }

    /**
     * @param id  персонажа
     * @return страница персонажа
     */
    @GetMapping("/{id}")
    public String getChar(Model model, @PathVariable("id") int id) {
        model.addAttribute("chars", serviceApi.getCharById(id));
        return "character";
    }

}
