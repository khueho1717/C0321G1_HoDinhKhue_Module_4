package com.example.manager_movie.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "movies",uniqueConstraints = {@UniqueConstraint(columnNames = "codeMovie")})
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String codeMovie;
    private String nameMovie;
    @Column(columnDefinition = "DATE")
    private String dateScreening;
    private int numberOfTickets;

    public Movies() {
    }

    public Movies(int id, String codeMovie, String nameMovie, String dateScreening, int numberOfTickets) {
        this.id = id;
        this.codeMovie = codeMovie;
        this.nameMovie = nameMovie;
        this.dateScreening = dateScreening;
        this.numberOfTickets = numberOfTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeMovie() {
        return codeMovie;
    }

    public void setCodeMovie(String codeMovie) {
        this.codeMovie = codeMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDateScreening() {
        return dateScreening;
    }

    public void setDateScreening(String dateScreening) {
        this.dateScreening = dateScreening;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
