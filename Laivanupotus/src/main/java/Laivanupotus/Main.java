package Laivanupotus;

import Sovelluslogiikka.Laivanupotus;
import javax.swing.SwingUtilities;
import Laivanupotus.Kayttoliittyma.Käyttöliittymä;
/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        Laivanupotus laivapeli = new Laivanupotus();
        Käyttöliittymä liittyma = new Käyttöliittymä(laivapeli);
        SwingUtilities.invokeLater(liittyma);

    }
}
