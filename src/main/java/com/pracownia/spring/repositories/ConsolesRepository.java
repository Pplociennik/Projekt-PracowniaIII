package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Consoles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface ConsolesRepository extends CrudRepository<Consoles, Integer>, PagingAndSortingRepository<Consoles, Integer> {

    Consoles findByConsolesId(String consolesId);

    @Query("select count(*) from Consoles p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
