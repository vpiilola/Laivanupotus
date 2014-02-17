/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Laivanupotus.käyttöliittymä.Aloitunakyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Kayttoliittyma.Käyttöliittymä;

/**
 *
 * @author vpiilola
 */
public class AloitusNakyma extends JPanel {
   private NimenKuuntelija kuuntelija;
   private JTextField nimiKentta;
   
   public AloitusNakyma(Käyttöliittymä kayttoliittyma){
       this.setLayout(new GridLayout(3,1));
       this.kuuntelija = new NimenKuuntelija(kayttoliittyma);
   }
   
   public JPanel getPanel(){
       return this;
   }
   
   public void luo(){
       this.add(new JLabel("Tervetuloa pelaamaan laivanupotusta!"));
       this.add(new JLabel("Anna nimesi: "));
       this.add(kentta());
   }
   
   /*
   Nyt mennää heikoilla - mahtaako tehdä vielä mitään!
   */
   public JTextField kentta(){
             
       JTextField nimiKentta = new JTextField();
       nimiKentta.addActionListener(kuuntelija);
       
       kuuntelija.tuoKoponentit(nimiKentta);
       
       nimiKentta.add(nimiKentta);
       
       return nimiKentta;
       
   }
}
