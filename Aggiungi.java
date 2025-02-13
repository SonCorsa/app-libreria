import javax.swing.*;
import java.awt.*;

public class Aggiungi extends JFrame{

    private JButton aggiungi,indietro;
    private JTextField nome,autore,genere,npag;
    private JLabel lnome,lautore,lgenere,lnpag;
    private JPanel indietroPanel,aggiungiPanel;
    
    public Aggiungi(String titolo){
        super(titolo);

        setLayout(new BorderLayout());

        //istanzio JButton
        JButton aggiungi = new JButton("aggiungi");
        JButton indietro = new JButton("<");

        //istanzio JTextField
        JTextField nome = new JTextField();
        JTextField autore = new JTextField();
        JTextField genere = new JTextField();
        JTextField npag = new JTextField();

        //istanzio JLabel
        JLabel lnome = new JLabel("Nome");
        JLabel lautore = new JLabel("Autore");
        JLabel lgenere = new JLabel("Genere");
        JLabel lnpag = new JLabel("Numero pagine");

        //istanzio JPanel
        JPanel indietroPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel aggiungiPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        //aggiungo i componenti ai JPanel
        indietroPanel.add(indietro);
        aggiungiPanel.add(aggiungi);

        //aggiungo al JFrame
        add(indietroPanel,BorderLayout.NORTH);
        add(aggiungiPanel,BorderLayout.SOUTH);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
