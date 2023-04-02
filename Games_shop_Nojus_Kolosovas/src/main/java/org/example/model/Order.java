package org.example.model;

import jakarta.xml.bind.annotation.*;

import javax.persistence.*;
import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"id", "orderDate", "buyers", "Games"})
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "CreatorsOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String orderDate;

    @XmlElementWrapper(name="buyers")
    @XmlElement(name="buyer")
    @OneToMany(targetEntity = Buyer.class, cascade = CascadeType.ALL)
    private List<Buyer> buyers;

    @XmlElementWrapper(name="games")
    @XmlElement(name="game")
    @OneToMany(targetEntity = Game.class, cascade = CascadeType.ALL)
    private List<Game> games;

    public Order(){}

    public Order(int id, String orderDate, List<Buyer> buyers, List<Game> games) {
        this.id = id;
        this.orderDate = orderDate;
        this.buyers = buyers;
        this.games = games;
    }

    public Order(String orderDate, List<Buyer> buyers, List<Game> games) {
        this.orderDate = orderDate;
        this.buyers = buyers;
        this.games = games;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return String.format("Order:\n\t Date = %s\n\t" +
                        "Buyers: \n\t%s" +
                        "Games:\n\t\t%s",
                this.orderDate,
                this.buyers,
                this.games,
                constructBuyerString(),
                constructGameString());
    }

    private String constructBuyerString(){
        String resultBuyer = "";
        for(Buyer buyer : this.buyers){
            resultBuyer += buyer.toString();
        }
        return resultBuyer;
    }

    private String constructGameString(){
        String resultGame = "";
        for(Game game : this.games){
            resultGame += game.toString();
        }
        return resultGame;
    }
}
