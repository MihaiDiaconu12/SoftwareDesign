package presentation;

import com.mysql.cj.xdevapi.Client;
import entity.Destinations;
import entity.Packs;
import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClientMenu {
    public JPanel clientMenuPanel;
    private JComboBox comboBoxPacks;
    private JTextField textFieldFilter;
    private JButton filterButton;
    private JButton bookVacationButton;
    private JTextArea textArea1;
    private JButton remove1Button;
    private JTextArea textArea2;
    private JButton remove2Button;
    private JTextArea textArea3;
    private JButton remove3Button;

    public ClientMenu(Users user){

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        ArrayList<Packs> packs;
        packs = (ArrayList<Packs>) em.createQuery("SELECT u from Packs u WHERE u.currentpersons <> '0'").getResultList();
        em.getTransaction().commit();
        em.close();

        for (Packs i: packs) {
            comboBoxPacks.addItem(i);
        }

        textArea1.setText(user.getVacation1());
        textArea2.setText(user.getVacation2());
        textArea3.setText(user.getVacation3());
        bookVacationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Packs p1= (Packs) comboBoxPacks.getSelectedItem();
                if(!(user.getVacation1().equals(""))&&!(user.getVacation2().equals(""))&&!(user.getVacation3().equals(""))){
                    JOptionPane.showMessageDialog(null,"You have already 3 destinations. Remove one.");
                }else{
                    if((user.getVacation1().equals("")&&user.getVacation2().equals("")&&user.getVacation3().equals(""))||
                            (user.getVacation1().equals("")&&!(user.getVacation2().equals(""))&&!(user.getVacation3().equals("")))||
                            (user.getVacation1().equals("")&&!(user.getVacation2().equals(""))&&user.getVacation3().equals(""))||
                            (user.getVacation1().equals("")&&user.getVacation2().equals("")&&!(user.getVacation3().equals("")))){
                        textArea1.setText(p1.getName());
                        user.setVacation1(p1.getName());
                        EntityManager em1 = entityManagerFactory.createEntityManager();
                        em1.getTransaction().begin();
                        String auxil=Integer.toString(Integer.parseInt(p1.getCurrentpersons())-1);
                        em1.createQuery("UPDATE Packs u Set u.currentpersons = :currentpersons WHERE u.id LIKE :id").setParameter("currentpersons",auxil).setParameter("id",p1.getId()).executeUpdate();
                        em1.createQuery("UPDATE Users u set u.vacation1=:nameVac WHERE u.id LIKE :id").setParameter("nameVac",p1.getName()).setParameter("id",user.getId()).executeUpdate();


                        comboBoxPacks.removeAllItems();
                        ArrayList<Packs> packsAux = (ArrayList<Packs>) em1.createQuery("SELECT u from Packs u WHERE u.currentpersons <> '0'").getResultList();
                        for (Packs i: packsAux) {
                            comboBoxPacks.addItem(i);
                        }
                        em1.getTransaction().commit();
                        em1.close();
                    }else
                    {
                        if(!(user.getVacation1().equals(""))&&user.getVacation2().equals("")&&!(user.getVacation3().equals(""))||
                                !(user.getVacation1().equals(""))&&user.getVacation2().equals("")&&user.getVacation3().equals("")){
                            textArea2.setText(p1.getName());
                            user.setVacation2(p1.getName());
                            EntityManager em1 = entityManagerFactory.createEntityManager();
                            em1.getTransaction().begin();
                            String auxil=Integer.toString(Integer.parseInt(p1.getCurrentpersons())-1);
                            em1.createQuery("UPDATE Packs u Set u.currentpersons = :currentpersons WHERE u.id LIKE :id").setParameter("currentpersons",auxil).setParameter("id",p1.getId()).executeUpdate();
                            em1.createQuery("UPDATE Users u set u.vacation2=:nameVac WHERE u.id LIKE :id").setParameter("nameVac",p1.getName()).setParameter("id",user.getId()).executeUpdate();


                            comboBoxPacks.removeAllItems();
                            ArrayList<Packs> packsAux = (ArrayList<Packs>) em1.createQuery("SELECT u from Packs u WHERE u.currentpersons <> '0'").getResultList();
                            for (Packs i: packsAux) {
                                comboBoxPacks.addItem(i);
                            }
                            em1.getTransaction().commit();
                            em1.close();

                        }else{
                            textArea3.setText(p1.getName());
                            user.setVacation3(p1.getName());
                            EntityManager em1 = entityManagerFactory.createEntityManager();
                            em1.getTransaction().begin();
                            String auxil=Integer.toString(Integer.parseInt(p1.getCurrentpersons())-1);
                            em1.createQuery("UPDATE Packs u Set u.currentpersons = :currentpersons WHERE u.id LIKE :id").setParameter("currentpersons",auxil).setParameter("id",p1.getId()).executeUpdate();
                            em1.createQuery("UPDATE Users u set u.vacation3=:nameVac WHERE u.id LIKE :id").setParameter("nameVac",p1.getName()).setParameter("id",user.getId()).executeUpdate();


                            comboBoxPacks.removeAllItems();
                            ArrayList<Packs> packsAux = (ArrayList<Packs>) em1.createQuery("SELECT u from Packs u WHERE u.currentpersons <> '0'").getResultList();
                            for (Packs i: packsAux) {
                                comboBoxPacks.addItem(i);
                            }
                            em1.getTransaction().commit();
                            em1.close();
                        }
                    }
                }
            }
        });


        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filter=textFieldFilter.getText();
                comboBoxPacks.removeAllItems();
                if(filter.equals("")){
                    for (Packs i: packs) {
                        comboBoxPacks.addItem(i);
                    }
                }else{
                    for (Packs i:packs) {
                        if(Integer.parseInt(filter)>=Integer.parseInt(i.getPrice())){
                            comboBoxPacks.addItem(i);
                        }
                    }
                }
            }

        });


        remove1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosen = textArea1.getText();
                if(!chosen.equals("")){
                    textArea1.setText("");
                    EntityManager em1 = entityManagerFactory.createEntityManager();
                    em1.getTransaction().begin();

                    ArrayList<Packs> aux= (ArrayList<Packs>) em1.createQuery("SELECT u FROM Packs u WHERE u.name LIKE :name ").setParameter("name",chosen).getResultList();
                    String s=Integer.toString(Integer.parseInt(aux.get(0).getCurrentpersons())+1);
                    em1.createQuery("UPDATE Packs u Set u.currentpersons = :current WHERE u.name LIKE :name").setParameter("name",chosen).setParameter("current",s).executeUpdate();
                    em1.createQuery("UPDATE Users u set u.vacation1=:theString WHERE u.id LIKE :id").setParameter("theString","").setParameter("id",user.getId()).executeUpdate();

                    comboBoxPacks.removeAllItems();
                    ArrayList<Packs> packsAux = (ArrayList<Packs>) em1.createQuery("SELECT u from Packs u WHERE u.currentpersons <> '0'").getResultList();
                    for (Packs i: packsAux) {
                        comboBoxPacks.addItem(i);
                    }
                    em1.getTransaction().commit();
                    em1.close();
                }
            }
        });


        remove2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosen = textArea2.getText();
                if(!chosen.equals("")){
                    textArea2.setText("");
                    EntityManager em1 = entityManagerFactory.createEntityManager();
                    em1.getTransaction().begin();

                    ArrayList<Packs> aux= (ArrayList<Packs>) em1.createQuery("SELECT u FROM Packs u WHERE u.name LIKE :name ").setParameter("name",chosen).getResultList();
                    String s=Integer.toString(Integer.parseInt(aux.get(0).getCurrentpersons())+1);
                    em1.createQuery("UPDATE Packs u Set u.currentpersons = :current WHERE u.name LIKE :name").setParameter("name",chosen).setParameter("current",s).executeUpdate();
                    em1.createQuery("UPDATE Users u set u.vacation2=:theString WHERE u.id LIKE :id").setParameter("theString","").setParameter("id",user.getId()).executeUpdate();

                    comboBoxPacks.removeAllItems();
                    ArrayList<Packs> packsAux = (ArrayList<Packs>) em1.createQuery("SELECT u from Packs u WHERE u.currentpersons <> '0'").getResultList();
                    for (Packs i: packsAux) {
                        comboBoxPacks.addItem(i);
                    }

                    em1.getTransaction().commit();
                    em1.close();
                }
            }
        });


        remove3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosen = textArea3.getText();
                if(!chosen.equals("")){
                    textArea3.setText("");
                    EntityManager em1 = entityManagerFactory.createEntityManager();
                    em1.getTransaction().begin();

                    ArrayList<Packs> aux= (ArrayList<Packs>) em1.createQuery("SELECT u FROM Packs u WHERE u.name LIKE :name ").setParameter("name",chosen).getResultList();
                    String s=Integer.toString(Integer.parseInt(aux.get(0).getCurrentpersons())+1);
                    em1.createQuery("UPDATE Packs u Set u.currentpersons = :current WHERE u.name LIKE :name").setParameter("name",chosen).setParameter("current",s).executeUpdate();
                    em1.createQuery("UPDATE Users u set u.vacation3=:theString WHERE u.id LIKE :id").setParameter("theString","").setParameter("id",user.getId()).executeUpdate();

                    comboBoxPacks.removeAllItems();
                    ArrayList<Packs> packsAux = (ArrayList<Packs>) em1.createQuery("SELECT u from Packs u WHERE u.currentpersons <> '0'").getResultList();
                    for (Packs i: packsAux) {
                        comboBoxPacks.addItem(i);
                    }

                    em1.getTransaction().commit();
                    em1.close();
                }
            }
        });
    }
}
