/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laivanupotus.Kayttoliittyma;

import Laivanupotus.Kayttoliittyma.Käyttöliittymä;
import Laivanupotus.Kayttoliittyma.LautaRuutu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Sovelluslogiikka.Pelaaja;

import Laivanupotus.Kayttoliittyma.Käyttöliittymä;
import Sovelluslogiikka.Laivanupotus;
import Sovelluslogiikka.Pelaaja;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import javax.swing.JLabel;

import java.math.MathContext;
import java.text.NumberFormat;

/**
 *
 * @author vpiilola@cs
 */
public class AmmunKuuntelija implements ActionListener {

    private Käyttöliittymä liittyma;
    int leveys;
    int korkeus;
    LautaRuutu painike;
    private JFrame lopetus;

    public AmmunKuuntelija(Käyttöliittymä kayttoliittyma, int x, int y, LautaRuutu nappi) {
        this.liittyma = kayttoliittyma;
        this.leveys = x;
        this.korkeus = y;
        this.painike = nappi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int tulos = this.liittyma.peli.Ammu(this.leveys, this.korkeus);

        if (tulos == 1 || tulos == 2) {
            this.painike.setText("x");
            this.liittyma.PaivitaYlaosa();

            if (!this.liittyma.peli.onkoPeliaJaljella()) {
                this.liittyma.getFrame().setVisible(false);

                lopetus = new JFrame("Peli päättyi");
                lopetus.setPreferredSize(new Dimension(300, 200));

                lopetus.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                
                lopetus.setLayout(new GridLayout(2,1));
                
                JLabel onnittelu = new JLabel("Onnittelut! Voitit pelin!");
                
                
                
                JLabel prosentti = new JLabel("Osumaprosenttisi oli: " + (6/(this.liittyma.getAmpumaKerrat())));
                
                
                lopetus.add(onnittelu);
                lopetus.add(prosentti);
                
                lopetus.pack();
                lopetus.setVisible(true);
             
                

            }
        } else if (tulos == 0) {
            this.painike.setText("---");
            this.liittyma.PaivitaYlaosa();
        }

    }

}
