package com.pracownia.spring.services;

import com.pracownia.spring.entities.Consoles;
import com.pracownia.spring.repositories.ConsolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Consoles service implement.
 */
@Service
public class ConsolesServiceImpl implements ConsolesService {

    @Autowired
    private ConsolesRepository consolesRepository;

    @Override
    public Iterable<Consoles> listAllConsolesPaging(Integer pageNr, Integer howManyOnPage) {
        return consolesRepository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Consoles> listAllConsoles() {
        return consolesRepository.findAll();
    }

    @Override
    public Consoles getConsolesById(Integer id) {
        return consolesRepository.findOne(id);
    }

    @Override
    public Consoles saveConsoles(Consoles consoles) {
        return consolesRepository.save(consoles);
    }

    @Override
    public void deleteConsoles(Integer id) {
        consolesRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (consolesRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }


}

