package com.itkolleg.studire.domain;



import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Student.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "matrikel_nummer")
    private Long matrikelNummer;

    @NotNull
    @Column(name = "nachname", nullable = false)
    private String nachname;

    @NotNull
    @Column(name = "vorname", nullable = false)
    private String vorname;

    @NotNull
    @Column(name = "street", nullable = false)
    private String street;

    @NotNull
    @Column(name = "plz", nullable = false)
    private Integer plz;

    @NotNull
    @Column(name = "location", nullable = false)
    private String location;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatrikelNummer() {
        return matrikelNummer;
    }

    public Student matrikelNummer(Long matrikelNummer) {
        this.matrikelNummer = matrikelNummer;
        return this;
    }

    public void setMatrikelNummer(Long matrikelNummer) {
        this.matrikelNummer = matrikelNummer;
    }

    public String getNachname() {
        return nachname;
    }

    public Student nachname(String nachname) {
        this.nachname = nachname;
        return this;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public Student vorname(String vorname) {
        this.vorname = vorname;
        return this;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStreet() {
        return street;
    }

    public Student street(String street) {
        this.street = street;
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPlz() {
        return plz;
    }

    public Student plz(Integer plz) {
        this.plz = plz;
        return this;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getLocation() {
        return location;
    }

    public Student location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        if (student.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + getId() +
            ", matrikelNummer=" + getMatrikelNummer() +
            ", nachname='" + getNachname() + "'" +
            ", vorname='" + getVorname() + "'" +
            ", street='" + getStreet() + "'" +
            ", plz=" + getPlz() +
            ", location='" + getLocation() + "'" +
            "}";
    }
}
