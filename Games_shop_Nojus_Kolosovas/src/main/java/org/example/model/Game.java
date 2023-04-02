package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String creator;
    private String publisher;
    private String game_name;
    private int cost;

    public Game(){}

    public Game(int id, String creator, String publisher, String game_name, int cost) {
        this.id = id;
        this.creator = creator;
        this.publisher = publisher;
        this.game_name = game_name;
        this.cost = cost;
    }

    public Game(String creator, String publisher, String game_name, int cost) {
        this.creator = creator;
        this.publisher = publisher;
        this.game_name = game_name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("\tTrip:\n\t\t\t\t" + "Creator = %s\n\t\t\t\t" + "Publisher = %s\n\t\t\t\t" +
                        "Game name = %s\n\t\t\t\t" + "Cost = %s\n\t\t\t\t",
                this.creator,
                this.publisher,
                this.game_name,
                this.cost);
    }

}
