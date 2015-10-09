/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infdev.mmorpg.pkg2.pkg0;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

/**
 *
 * @author Roy van den Heuvel
 */
public class INFDEVMMORPG20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //generateJunk();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame login = new JFrame("MMORPG!");
                login.setContentPane(new StartScreen());
                login.pack();
                login.setVisible(true);
            }
        });
    }

    
    public static void generateJunk(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            Users filler = new Users();
            filler.setBalance(0);
            filler.setBanned(false);
            filler.setCharacterSlots(5);
            filler.setFirstName("Firstname"+i);
            filler.setIban("iban"+i);
            filler.setUserName("username"+i);
            filler.setLastName("Lastname"+i);
            filler.setPassword("password"+i);
            filler.setMonthsPaid(0);
            
            Characters fillerChar = new Characters();
            fillerChar.setClass1("Warrior");
            fillerChar.setLevel((int) Math.ceil(Math.random() * 100));
            fillerChar.setName("Charname"+i);
            fillerChar.setRace("Orc");
            Collection<Users> ownerFiller = new ArrayList<Users>();
            ownerFiller.add(filler);
            fillerChar.setUsersCollection(ownerFiller);
            
            persist(filler);
            persist(fillerChar);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Adding all the objects took " + (endTime - startTime) + " milliseconds.");
    }
    
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("INFDEV_MMORPG_2.0PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
