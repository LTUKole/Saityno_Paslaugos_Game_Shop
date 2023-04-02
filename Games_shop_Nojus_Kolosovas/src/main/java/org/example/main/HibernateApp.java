package org.example.main;

import org.example.model.Buyer;
import org.example.model.Game;
import org.example.model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    private static org.example.main.HibernateUtil HibernateUtil;

    public static void main(String[] args){

        Game game1 = new Game("CDProject", "Publisher", "Cyberpunk", 50);
        Buyer buyer1 = new Buyer("Katerina", "Smith");
        Order order1 = new Order("2023", List.of(buyer1), List.of(game1));

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(order1);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Order> orders = session.createQuery("from Order", Order.class).list();
            orders.forEach(ordr -> System.out.println());

            System.out.println("---------------------------------");
            orders.forEach(ordr -> Util.JaxbUtil.convertToXML(ordr));

            //server = Server.createTcpServer().start();
            System.in.read();
        }catch (Exception e){
            if(transaction != null){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            //server.shutdown();
        }
    }
}
