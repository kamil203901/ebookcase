package pl.kazmierczak.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kamil on 22.09.17.
 */
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    //private final Logger log = LoggerFactory.getLogger(getClass());

    public Author() {}

    public Author(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;

        //log.info("Author created: " + id + " " + name + " " + surname);
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
