package presentation;

import entity.Destinations;
import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartMenu {
    private JButton travelAgencyButton;
    private JButton registerButton;
    private JButton loginButton;
    private JTextField textFieldTravelAgency;
    public JPanel startMenuPanel;
    private JTextField loginUsername;
    private JTextField loginPassword;
    private JTextField registerName;
    private JTextField registerEmail;
    private JTextField registerPassword;

    public StartMenu(){

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        ArrayList<Users> users;
        users = (ArrayList<Users>) em.createQuery("SELECT u from Users u").getResultList();
        em.getTransaction().commit();
        em.close();

        travelAgencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPass = textFieldTravelAgency.getText();
                if(inputPass.equals("sustapersusta")){
                    JFrame frame = new JFrame("Agency menu");
                    frame.setContentPane(new TravelAgency().agencyPanel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }else
                {
                    JOptionPane.showMessageDialog(null,"Are you certain that you are the manager?");
                }
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=loginUsername.getText();
                String pass=loginPassword.getText();

                boolean aux=false;
                Users theOne=new Users();
                for (Users i:users) {
                    if((i.getUsername().equals(name)&&i.getPassword().equals(pass))||(i.getEmail().equals(name)&&i.getPassword().equals(pass))){
                        aux=true;
                        theOne=i;
                        break;
                    }
                }

                if(aux){
                    JFrame frame = new JFrame("Client menu");
                    frame.setContentPane(new ClientMenu(theOne).clientMenuPanel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
                else{JOptionPane.showMessageDialog(null,"Are you who you claim to be?");}
            }
        });


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=registerName.getText();
                String email=registerEmail.getText();
                String pass=registerPassword.getText();
                int aux=users.size()+1;
                String newId=Integer.toString(aux);
                Users user=new Users(newId,name,email,pass,"","","");

                EntityManager em1 = entityManagerFactory.createEntityManager();
                em1.getTransaction().begin();
                em1.persist(user);
                em1.getTransaction().commit();
                em1.close();

                JFrame frame = new JFrame("Client menu");
                frame.setContentPane(new ClientMenu(user).clientMenuPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
