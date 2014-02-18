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

import Laivanupotus.Kayttoliittyma.Käyttöliittymä;

/**
 *
 * @author vpiilola
 */
public class AloitusNakyma extends JPanel {
   private Käyttöliittymä liittyma;
   private NimenKuuntelija kuuntelija;
   private JTextField nimiKentta;
   private JButton painike;
   
   public AloitusNakyma(Käyttöliittymä kayttoliittyma){
       this.setLayout(new GridLayout(4,1));
       this.liittyma = kayttoliittyma;
      
   }
   
   public JPanel getPanel(){
       return this;
   }
   
   public void luo(){
       this.add(new JLabel("Tervetuloa pelaamaan laivanupotusta!"));
       this.add(new JLabel("Anna nimesi: "));
       
       nimiKentta = new JTextField();
       this.add(nimiKentta);
       
       kuuntelija = new NimenKuuntelija(liittyma, nimiKentta);
       painike = new JButton("Aloita");
       painike.addActionListener(kuuntelija);
       this.add(painike);
       
       
   }
   
   /*
   Nyt mennää heikoilla - mahtaako tehdä vielä mitään!
   */
//   public JButton nappula(){
//             
//       kuuntelija = new NimenKuuntelija(Käyttöliittymä liittyma, JTextField kentta);
//       painike = new JButton("Aloita");       
//       painike.addActionListener(kuuntelija);
//       
//       
//       return painike;
//       
//   }
}
