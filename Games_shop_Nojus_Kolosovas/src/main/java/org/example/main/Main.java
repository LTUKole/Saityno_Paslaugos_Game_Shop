package org.example.main;

import jakarta.xml.bind.JAXBException;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.example.model.Buyer;
import org.example.model.Game;
import org.example.model.Order;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {

        Game game1 = new Game("CDProject", "Publisher", "Cyberpunk", 50);
        Game game2 = new Game("Rockstar", "Publisher", "GTA 5", 25);
        Buyer buyer1 = new Buyer("Katerina", "Smith");
        Order order1 = new Order("2023-02-25", List.of(buyer1), List.of(game1, game2));

        Util.JaxbUtil.convertToXML(order1);
        System.out.println(order1);

    }
}