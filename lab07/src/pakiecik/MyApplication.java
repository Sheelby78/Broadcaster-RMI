package pakiecik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyApplication {
    private JPanel mainPanel;
    private JPanel Panel1;
    private JPanel card1;
    private JButton broadcasterButton;
    private JButton editorButton;
    private JButton customerButton;
    private JButton startButton;
    private JPanel card2;
    private JPanel card3;
    private JButton strButton;
    private JButton button1;
    private JTextArea text1;
    private JButton powrotButton;

    public JTextArea getText2() {
        return text2;
    }

    private JTextArea text2;
    private JTextField podajSwojaNazweTextField;
    private JTextField poleText1;
    private JPanel card4;
    private JPanel parent2;
    private JPanel card11;
    private JButton dodwanieOgloszeniaButton;
    private JButton usuwanieOgłoszeniaButton;
    private JButton pokazListeOdbiorcowButton;
    private JPanel card12;
    private JButton dodajOgloszenieButton;
    private JTextArea dodajText;
    private JTextField idDodanegoOgloszeniaTextField;
    private JTextField poleId;
    private JButton powrotButton1;
    private JPanel card13;
    private JButton usunButton;
    private JTextField idUsuniecie;
    private JTextField podajIdOgloszeniaDoTextField;
    private JButton powrotButton2;
    private JPanel card14;
    private JButton wyswietlListeOdbiorcowButton;
    private JTextArea listaUczestnikow;
    private JButton powrotButton3;

    public MyApplication() throws RemoteException {
        broadcasterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.removeAll();
                Panel1.add(card2);
                Panel1.repaint();
                Panel1.revalidate();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.start();
            }
        });
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.removeAll();
                Panel1.add(card3);
                Panel1.repaint();
                Panel1.revalidate();
            }
        });
        strButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.register(poleText1.getText());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.unregister(poleText1.getText());
            }
        });
        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.removeAll();
                Panel1.add(card1);
                Panel1.repaint();
                Panel1.revalidate();
            }
        });
        editorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel1.removeAll();
                Panel1.add(card4);
                Panel1.repaint();
                Panel1.revalidate();
            }
        });
        dodwanieOgloszeniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent2.removeAll();
                parent2.add(card12);
                parent2.repaint();
                parent2.revalidate();
            }
        });
        usuwanieOgłoszeniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent2.removeAll();
                parent2.add(card13);
                parent2.repaint();
                parent2.revalidate();
            }
        });
        pokazListeOdbiorcowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent2.removeAll();
                parent2.add(card14);
                parent2.repaint();
                parent2.revalidate();
            }
        });
        powrotButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent2.removeAll();
                parent2.add(card11);
                parent2.repaint();
                parent2.revalidate();
            }
        });
        powrotButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent2.removeAll();
                parent2.add(card11);
                parent2.repaint();
                parent2.revalidate();
            }
        });
        powrotButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent2.removeAll();
                parent2.add(card11);
                parent2.repaint();
                parent2.revalidate();
                listaUczestnikow.setText("");
            }
        });
        dodajOgloszenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                poleId.setText(String.valueOf(edit.dodaj(dodajText.getText())));
                dodajText.setText("");
            }
        });
        wyswietlListeOdbiorcowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.uczestnicy();
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit.usun(Integer.parseInt(idUsuniecie.getText()));
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    Broadcaster b = new Broadcaster();
    Customer c = new Customer(text1);
    Editor edit = new Editor(listaUczestnikow);

}
