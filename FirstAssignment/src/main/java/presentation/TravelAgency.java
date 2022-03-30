package presentation;

import entity.Destinations;
import entity.Packs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TravelAgency {
    private JTextField destinationField;
    private JButton addDestinationButton;
    private JComboBox destinationsComboBox;
    private JButton deleteDestinationButton;
    public JPanel agencyPanel;
    private JButton deletePackageButton;
    private JButton editPackageButton;
    private JTextField editTextField;
    private JComboBox editComboBox;
    private JButton addPackageButton;
    private JComboBox destination2ComboBox;
    private JTextField textFieldDay2;
    private JTextField textFieldMonth2;
    private JTextField textFieldDay1;
    private JTextField textFieldMonth1;
    private JTextField textFieldPackageName;
    private JTextField textFieldPrice;
    private JTextField textFieldAvailablePlaces;
    private JComboBox categoryComboBox;

    public TravelAgency(){

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        ArrayList<Destinations> destinations;
        destinations = (ArrayList<Destinations>) em.createQuery("SELECT u from Destinations u").getResultList();
        em.getTransaction().commit();
        em.close();

        EntityManager emX = entityManagerFactory.createEntityManager();
        emX.getTransaction().begin();
        ArrayList<Packs> packs;
        packs = (ArrayList<Packs>) emX.createQuery("SELECT u from Packs u").getResultList();
        emX.getTransaction().commit();
        emX.close();

        for(Packs i: packs){
            editComboBox.addItem(i);
        }

        for (Destinations i: destinations) {
            destinationsComboBox.addItem(i);
            destination2ComboBox.addItem(i);
        }

        categoryComboBox.addItem("name"); categoryComboBox.addItem("price"); categoryComboBox.addItem("maxplaces");

        addDestinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                boolean isAlreadyThere=false;
                for (Destinations i: destinations) {
                    if(i.getName().equals(destinationField.getText())){
                        isAlreadyThere=true;
                        break;
                    }
                }
                if(isAlreadyThere){
                    JOptionPane.showMessageDialog(null,"The destination is already there");
                }else{
                    int index=destinations.size()-1;
                    int newId=Integer.parseInt(destinations.get(index).getId())+1;
                    String s=Integer.toString(newId);
                    Destinations destination=new Destinations(s,destinationField.getText());

                    EntityManager em1 = entityManagerFactory.createEntityManager();
                    em1.getTransaction().begin();
                    em1.persist(destination);
                    em1.getTransaction().commit();
                    em1.close();

                    destinations.add(destination);
                    destinationsComboBox.addItem(destination);
                    destination2ComboBox.addItem(destination);
                }
            }
        });


        deleteDestinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Destinations chosen  = (Destinations) destinationsComboBox.getSelectedItem();
                destinationsComboBox.removeItem(chosen);
                destination2ComboBox.removeItem(chosen);
                EntityManager em1 = entityManagerFactory.createEntityManager();
                em1.getTransaction().begin();
                em1.createQuery("DELETE FROM Destinations u WHERE u.id LIKE :id").setParameter("id",chosen.getId()).executeUpdate();
                em1.getTransaction().commit();
                em1.close();
            }
        });


        addPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Destinations chosen = (Destinations) destination2ComboBox.getSelectedItem();
                String sId;
                    int index=packs.size()-1;
                    int newId=Integer.parseInt(packs.get(index).getId())+1;
                    sId=Integer.toString(newId);


                Packs pack=new Packs(sId,textFieldPackageName.getText(),chosen.getName(),textFieldPrice.getText(),textFieldAvailablePlaces.getText(),
                        textFieldAvailablePlaces.getText(),textFieldDay1.getText(),textFieldMonth1.getText(),textFieldDay2.getText(),textFieldMonth2.getText());
                editComboBox.addItem(pack);

                EntityManager em1 = entityManagerFactory.createEntityManager();
                em1.getTransaction().begin();
                em1.persist(pack);
                em1.getTransaction().commit();
                em1.close();
            }
        });


        editPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cat = (String) categoryComboBox.getSelectedItem();
                Packs pack= (Packs) editComboBox.getSelectedItem();
                String value = editTextField.getText();
                EntityManager em1 = entityManagerFactory.createEntityManager();
                em1.getTransaction().begin();
                if(cat.equals("name")){
                    em1.createQuery("UPDATE Packs u Set u.name = :name WHERE u.id LIKE :id").setParameter("id",pack.getId()).setParameter("name",value).executeUpdate();
                    ((Packs) editComboBox.getSelectedItem()).setName(value);
                }
                if(cat.equals("price")){
                    em1.createQuery("UPDATE Packs u Set u.price = :price WHERE u.id LIKE :id").setParameter("id",pack.getId()).setParameter("price",value).executeUpdate();
                    ((Packs) editComboBox.getSelectedItem()).setPrice(value);
                }
                if(cat.equals("maxplaces")){
                    em1.createQuery("UPDATE Packs u Set u.maxpersons = :maxpersons WHERE u.id LIKE :id").setParameter("id",pack.getId()).setParameter("maxpersons",value).executeUpdate();
                    ((Packs) editComboBox.getSelectedItem()).setMaxpersons(value);
                }
                em1.getTransaction().commit();
                em1.close();
            }
        });


        deletePackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Packs pack= (Packs) editComboBox.getSelectedItem();
                EntityManager em1 = entityManagerFactory.createEntityManager();
                em1.getTransaction().begin();
                em1.createQuery("DELETE FROM Packs u WHERE u.id LIKE :id").setParameter("id",pack.getId()).executeUpdate();
                em1.getTransaction().commit();
                em1.close();
                editComboBox.removeItem(pack);
            }
        });
    }
}
