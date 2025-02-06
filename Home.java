import java.awt.*;
import javax.swing.*;

public class Home{
    //ciao roberto mi manchi mentre stai spiegando alla lavagna.
    //ricordati di NON toccare nessuno degli altri file,ho mi fotti il lavoro.
    //ho già creato la branch, lavorato sopra, fatto il merge ed eliminato la branch perciò qualsiasi cosa fai lavora SOLO su questo file.
    //i test li facciamo quando facciamo il merge
    //muah :3
    private JFrame homePage;
    private JButton profileButton; 
    private JLabel label; 
    private JPanel panel;
    
    public Home(String titolo){
        homePage= new JFrame(titolo);
        homePage.setLayout(new BoxLayout(homePage,BoxLayout.Y_AXIS));
        
        profileButton = new JButton("profilo");
        label = new JLabel("Reading");
        panel = new JPanel(new BorderLayout());

        panel.add(profileButton,BorderLayout.EAST);
        panel.add(label,BorderLayout.WEST);
        homePage.add(panel);
        

        homePage.setSize(300,200);
        homePage.setLocationRelativeTo(null);
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b){
        homePage.setVisible(b);
    }

    /*ToDo:
     * sistemare il BoxLayout
     * mettere le altre 3 righe
     * inserire l'immagine nel JButton
     * impostare il JButton come un cerchio
     * creare il Listener
     * 
     */
    
}
