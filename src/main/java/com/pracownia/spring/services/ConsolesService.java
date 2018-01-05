package com.pracownia.spring.services;

import com.pracownia.spring.entities.Consoles;

public interface ConsolesService {

    Iterable<Consoles> listAllConsoles();

    Consoles getConsolesById(Integer id);

    Consoles saveConsoles(Consoles consoles);

    void deleteConsoles(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Consoles> listAllConsolesPaging(Integer pageNr, Integer howManyOnPage);

}
