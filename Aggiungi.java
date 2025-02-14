import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Aggiungi extends JFrame{

    private JButton aggiungi,indietro,copertina;
    private JTextField nome,autore,genere,npag;
    private JLabel lnome,lautore,lgenere,lnpag;
    private JPanel indietroPanel,aggiungiPanel,p1;
    
    public Aggiungi(String titolo){
        super(titolo);

        setLayout(new BorderLayout());

        //istanzio JButton
        aggiungi = new JButton("aggiungi");
        indietro = new JButton("indietro");
        copertina = new JButton();
       
        //copertina del libro
        File fileicon = new File("app-libreria/Aggiungi.png");
        ImageIcon icon = new ImageIcon(fileicon.getAbsolutePath());
        copertina.setIcon(new ImageIcon(icon.getImage().getScaledInstance(185, 250, 5)));
                copertina.setOpaque(false);
        copertina.setBorderPainted(false);
        copertina.setContentAreaFilled(false);


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
        JPanel aggiungiPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JPanel p1 = new JPanel();

        //aggiungo i componenti ai JPanel
        indietroPanel.add(indietro);
        aggiungiPanel.add(aggiungi);

        //aggiungo al JFrame
        add(indietroPanel,BorderLayout.NORTH);
        add(aggiungiPanel,BorderLayout.SOUTH);
        add(copertina, BorderLayout.WEST);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //get dei JButton
    public JButton getAggiungi() {
        return aggiungi;
    }

    public JButton getIndietro() {
        return indietro;
    }

}
