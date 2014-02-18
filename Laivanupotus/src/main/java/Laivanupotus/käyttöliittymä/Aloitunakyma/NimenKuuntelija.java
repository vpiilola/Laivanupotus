/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laivanupotus.käyttöliittymä.Aloitunakyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Sovelluslogiikka.Pelaaja;

import Laivanupotus.Kayttoliittyma.Käyttöliittymä;
import Sovelluslogiikka.Laivanupotus;
import Sovelluslogiikka.Pelaaja;
import javax.swing.JTextField;

/**
 *
 * @author vpiilola
 */
public class NimenKuuntelija implements ActionListener {

    private Käyttöliittymä kayttoliittyma;
    private JTextField nimiKentta;
    private JButton painike;
    private Laivanupotus peli;

    public NimenKuuntelija(Käyttöliittymä käyttöliittymä, JTextField kentta) {
        this.kayttoliittyma = käyttöliittymä;        
        this.nimiKentta=kentta;

    }

    public void tuoKoponentit(JButton painike,JTextField nimiKentta) {
        this.painike = painike;
        this.nimiKentta = nimiKentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nimi = nimiKentta.getText();
        this.kayttoliittyma.getPelaaja().setNimi(nimi);
        
        this.kayttoliittyma.AloitaPeli();
        
        
    }

}
