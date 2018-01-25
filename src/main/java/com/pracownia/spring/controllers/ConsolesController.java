package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Consoles;
import com.pracownia.spring.services.ConsolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

//kontroler konsol
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsolesController {

    @Autowired
    private ConsolesService consolesService;


  //wypisanie wszystkich konsol
    @RequestMapping(value = "/consoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Consoles> list(Model model) {
        return consolesService.listAllConsoles();
    }

    @RequestMapping(value = "/consoles/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Consoles> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return consolesService.listAllConsolesPaging(pageNr, howManyOnPage.orElse(2));
    }


 //wyswietl dana konsole
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Consoles getByPublicId(@PathVariable("id") Integer publicId) {
        return consolesService.getConsolesById(publicId);
    }

//wyswietl konsole wybrana po id
    @RequestMapping(value = "/console", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Consoles getByParamPublicId(@RequestParam("id") Integer publicId) {
        return consolesService.getConsolesById(publicId);
    }

 //wyslij konsole do bazy danych
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    public ResponseEntity<Consoles> create(@RequestBody @Valid @NotNull Consoles consoles) {
        consoles.setConsolesId(UUID.randomUUID().toString());
        consolesService.saveConsoles(consoles);
        return ResponseEntity.ok().body(consoles);
    }


 //edytuj konsole w bazie danych
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Consoles consoles) {
        if (!consolesService.checkIfExist(consoles.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            consolesService.saveConsoles(consoles);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

//usun konsole wybrana po id
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Consoles> delete(@PathVariable Integer id) {
        consolesService.deleteConsoles(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
