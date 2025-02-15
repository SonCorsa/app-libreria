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

        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

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
       // indietroPanel.add(indietro);
       // aggiungiPanel.add(aggiungi);

      //TASTO INDIETRO
       c.weightx = 0.5;
       c.weighty = 0.5;
       c.gridx = 0;
       c.gridy = 0;
       c.anchor = GridBagConstraints.FIRST_LINE_START;
       add(indietro,c);



       //TASTO COPERTINA
       c.gridx = 1;
       c.gridy = 1;
       c.weightx = 10;
       add(copertina,c);
       
       //NOME
       c.gridx = 2;
       c.gridy = 1;
       c.weightx = 20 ;
       add(lnome,c); 
       
       c.insets = new Insets(20,0,0,1000);
       c.fill = GridBagConstraints.HORIZONTAL;
       add(nome,c);

       //AUTORE 
         c.gridx = 2;
         c.gridy = 1;
         c.insets = new Insets(40,0,0,0);
       add(lautore,c); 
       
       c.insets = new Insets(60,0,0,1000);
       c.fill = GridBagConstraints.HORIZONTAL;
       add(autore,c);

       //GENERE
       c.gridx = 2;
       c.gridy = 1;
       c.insets = new Insets(80,0,0,0);
       add(lgenere,c); 
     
       c.insets = new Insets(100,0,0,1000);
       c.fill = GridBagConstraints.HORIZONTAL;
       add(genere,c);

       //NUMERO PAGINE
       c.gridx = 2;
       c.gridy = 1;
       c.insets = new Insets(120,0,0,0);
       add(lnpag,c); 
     
       c.insets = new Insets(140,0,0,1000);
       c.fill = GridBagConstraints.HORIZONTAL;
       add(npag,c);


       //TASTO AGGIUNGI
       c.gridx = 2;
       c.gridy = 2;
       c.ipadx = 0;
       c.ipady = 0;
       c.fill = GridBagConstraints.NONE;
       c.insets = new Insets(0,0,0,0);
       c.anchor = GridBagConstraints.LAST_LINE_END;
       add(aggiungi,c);

        //aggiungo al JFrame
        //add(indietroPanel,BorderLayout.NORTH);
        //add(aggiungiPanel,BorderLayout.SOUTH);
        //add(copertina, BorderLayout.WEST);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

    }

    //get dei JButton
    public JButton getAggiungi() {
        return aggiungi;
    }

    public JButton getIndietro() {
        return indietro;
    }

}
