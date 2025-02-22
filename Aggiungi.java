import java.awt.*;
import java.io.File;
import javax.swing.*;

public class Aggiungi extends JFrame{

    private JButton aggiungi,indietro,copertina;
    private JTextField nome,autore,genere,npag;
    private JLabel lnome,lautore,lgenere,lnpag;
    private JPanel indietroPanel,aggiungiPanel,p1;
    private GridBagConstraints c;
    
    public Aggiungi(String titolo){
        super(titolo);

        //c = new GridBagConstraints();
        //setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //istanzio JButton
        aggiungi = new JButton("aggiungi");
        indietro = new JButton("indietro");
        copertina = new JButton();
       
        //copertina del libro
        File fileicon = new File("app-libreria/Aggiungi.png");
        ImageIcon icon = new ImageIcon(fileicon.getAbsolutePath());
        copertina.setIcon(new ImageIcon(icon.getImage().getScaledInstance(285, 370, 5)));
                copertina.setOpaque(false);
        copertina.setBorderPainted(false);
        copertina.setContentAreaFilled(false);


        //istanzio JTextField
        JTextField nome = new JTextField();
        JTextField autore = new JTextField();
        JTextField genere = new JTextField();
        JTextField npag = new JTextField();
        JTextField trama = new JTextField();

        //istanzio JLabel
        JLabel lnome = new JLabel("Nome");
        JLabel lautore = new JLabel("Autore");
        JLabel lgenere = new JLabel("Genere");
        JLabel lnpag = new JLabel("Numero pagine");
        JLabel ltrama= new JLabel("Trama");

        //istanzio JPanel
        JPanel indietroPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel aggiungiPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JPanel p1 = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        nome.setPreferredSize(new Dimension(250,20));
        autore.setPreferredSize(new Dimension(250,20));
        genere.setPreferredSize(new Dimension(250,20));
        npag.setPreferredSize(new Dimension(250,20));

       //TASTI INDIETRO E AGGIUNGI
        indietroPanel.add(indietro);
        aggiungiPanel.add(aggiungi);
        add(indietroPanel,BorderLayout.NORTH);
        add(aggiungiPanel,BorderLayout.SOUTH);


        //PANNELLO GRIDBAGLAYOUT
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        p1.add(copertina,c);
        
        //NOME E JTEXTFIELD
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        p1.add(lnome,c);

        c.insets = new Insets(35,0,0,0);
        p1.add(nome,c);

        //AUTORE E JTEXTFIELD
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(65,0,0,0);
        p1.add(lautore,c);

        c.insets = new Insets(100,0,0,0);
        p1.add(autore,c);

        //GENERE E JTEXTFIELD  
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(130,0,0,0);
        p1.add(lgenere,c);

        c.insets = new Insets(165,0,0,0);
        p1.add(genere,c);

        //NUMERO PAGINE E JTEXTFIELD
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(195,0,0,0);
        p1.add(lnpag,c);

        c.insets = new Insets(230,0,0,0);
        p1.add(npag,c);

        //TRAMA E JTEXTFIELD
        add(ltrama,BorderLayout.EAST.;

        
        
        
        
        add(p1,BorderLayout.WEST);
        
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

    public JButton getCopertina() {
        return copertina;
    }

}
