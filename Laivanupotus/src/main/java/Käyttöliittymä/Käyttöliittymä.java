/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.laivanupotus;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
//import jawa.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vesku
 */
public class Käyttöliittymä implements Runnable {

    private JFrame frame;
    Laivanupotus peli;

    public Käyttöliittymä(Laivanupotus laivapeli) {
        this.peli = laivapeli;
    }

    @Override
    public void run() {

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        aloitusRuutu(frame.getContentPane());
//
//        frame.pack();
//        frame.setVisible(true);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    /*
     * Luo toistaiseksi vain tekstikomponentit käyttöliittymälle
     */
    public void aloitusRuutu(Container container) {
        JLabel tervehdys = new JLabel("Tervetuloa pelaamaan laivanupotusta!");
        JLabel nimiTeksti = new JLabel("Anna nimesi: ");
        JTextField nimiKentta = new JTextField();

        container.add(tervehdys, BorderLayout.NORTH);
        container.add(nimiTeksti, BorderLayout.WEST);
        container.add(nimiKentta, BorderLayout.EAST);
    }

    public void luoKomponentit(Container container) {
        JLabel teksti = new JLabel("Tervetuloa pelaamaan laivanupotusta");

        container.add(teksti, BorderLayout.NORTH);

        container.add(luoRuudukko(), BorderLayout.SOUTH);
    }

    /*
     * Luo käyttöliittymään peliruudukon, josta näkyy aluksi
     * ruudut joihin mihinkään ei ole ammuttu
     */
    public JPanel luoRuudukko() {
        JPanel paneeli = new JPanel(new GridLayout(peli.getKorkeus(), peli.getLeveys()));

        for (int i = 0; i < peli.getKorkeus(); i++) {
            for (int j = 0; j < peli.getLeveys(); j++) {
                LautaRuutu ruutu = new LautaRuutu("0", i, j);
//                ruutu.addActionListener(this);
                paneeli.add(ruutu);
            }

        }
        return paneeli;
    }

}
