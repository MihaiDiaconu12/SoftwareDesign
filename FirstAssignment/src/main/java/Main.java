import entity.Destinations;
import entity.Packs;
import entity.Users;
import presentation.StartMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args){

        JFrame frame = new JFrame("Startmenu");
        frame.setContentPane(new StartMenu().startMenuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
