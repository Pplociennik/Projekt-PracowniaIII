package com.pracownia.spring.controllers;

//import com.pracownia.spring.services.ConsolesService;
import com.pracownia.spring.entities.Consoles;
import com.pracownia.spring.services.ConsolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.UUID;

//kontroler glowny
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ConsolesService consolesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String generateModel() {

        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime dateAndTime  = ZonedDateTime.of(localtDateAndTime, zoneId);


        Consoles c1 = new Consoles(1, "1", "XBOX", "360", "ELITE", "MICROSOFT", "2005");
        Consoles c2 = new Consoles(2, "2", "PLAYSTATION", "4", "PRO", "SONY", "2017");
        Consoles c3 = new Consoles(3, "3", "XBOX", "ONE", "X", "MICROSOFT", "2017");


        consolesService.saveConsoles(c1);
        consolesService.saveConsoles(c2);
        consolesService.saveConsoles(c3);


        return "Utworzono Konsole!";
    }

}
