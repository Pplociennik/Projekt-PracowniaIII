package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Product entity.
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "refId", scope = Consoles.class)
public class Consoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String consolesId;

    @Column
    private String consoleName;

    @Column
    private String model;

    @Column
    private String version;

    @Column
    private String developer;

    @Column
    private String relaseDate;

//    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,  CascadeType.REMOVE})
//    @JoinTable(name = "consoles_selles")
//    private Set<Player> sellers = new HashSet<>();

    //required by Hibernate
    public Consoles() {

    }


    public Consoles(Integer id, String consolesId, String consoleName, String model, String version, String developer, String relaseDate) {
        this.id = id;
        this.consolesId = consolesId;
        this.consoleName = consoleName;
        this.model = model;
        this.version = version;
        this.developer = developer;
        this.relaseDate = relaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsolesId() {
        return consolesId;
    }

    public void setConsolesId(String consolesId) {
        this.consolesId = consolesId;
    }

    public String getConsoleName() {
        return consoleName;
    }

    public void setConsoleName(String consoleName) {
        this.consoleName = consoleName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(String relaseDate) {
        this.relaseDate = relaseDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}


