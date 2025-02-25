import java.awt.*;
import java.io.File;
import javax.swing.*;

public class Aggiungi extends JPanel{

    private JButton aggiungi,indietro,copertina;
    private JTextField nome,autore,genere,npag,trama;
    private JLabel lnome,lautore,lgenere,lnpag,ltrama;
    private JPanel indietroPanel,aggiungiPanel,p1;
    private GridBagConstraints c;
    
    public Aggiungi(JFramePrincipale finestra){
        setLayout(new BorderLayout());
        //istanzio il panel

        //istanzio JButton
        aggiungi = new JButton("aggiungi");
        indietro = new JButton("indietro");
        copertina = new JButton();

        //setto l'immagine del bottone copertina
        setImmagineCopertina();
       

        //istanzio JTextField
        nome = new JTextField();
        autore = new JTextField();
        genere = new JTextField();
        npag = new JTextField();
        trama = new JTextField();

        //istanzio JLabel
        lnome = new JLabel("Nome");
        lautore = new JLabel("Autore");
        lgenere = new JLabel("Genere");
        lnpag = new JLabel("Numero pagine");
        ltrama= new JLabel("Trama");

        //istanzio JPanel
        indietroPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        aggiungiPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        p1 = new JPanel(new GridBagLayout());
        
        nome.setPreferredSize(new Dimension(250,20));
        autore.setPreferredSize(new Dimension(250,20));
        genere.setPreferredSize(new Dimension(250,20));
        npag.setPreferredSize(new Dimension(250,20));
        trama.setPreferredSize(new Dimension(250,100));
        
        //TASTI INDIETRO E AGGIUNGI
        indietroPanel.add(indietro);
        aggiungiPanel.add(aggiungi);
        add(indietroPanel,BorderLayout.NORTH);
        add(aggiungiPanel,BorderLayout.SOUTH);
        
        
        //PANNELLO GRIDBAGLAYOUT
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        c.gridheight = 11;
        c.anchor = GridBagConstraints.CENTER;
        p1.add(copertina,c);
        
        //LABEL NOME E TEXTFIELD NOME
        GridBagConstraints x= new GridBagConstraints();
        x.weightx = 0.5;
        x.gridx = 1;
        x.gridy = 0;
        x.anchor = GridBagConstraints.PAGE_START;
        p1.add(lnome,x);

        x.gridx = 1;
        x.gridy = 1;
        p1.add(nome,x);

        //LABEL AUTORE E TEXTFIELD AUTORE
        x.gridx = 1;
        x.gridy = 2;
        p1.add(lautore,x);

        x.gridx = 1;
        x.gridy = 3;
        p1.add(autore,x);

        //LABEL GENERE E TEXTFIELD GENERE
        x.gridx = 1;
        x.gridy = 4;
        p1.add(lgenere,x);

        x.gridx = 1;
        x.gridy = 5;
        p1.add(genere,x);

        //LABEL NUMERO PAGINE E TEXTFIELD NUMERO PAGINE
        x.gridx = 1;
        x.gridy = 6;
        p1.add(lnpag,x);

        x.gridx = 1;
        x.gridy = 7;
        p1.add(npag,x);

        //LABEL TRAMA E TEXTFIELD TRAMA
        x.gridx = 1;
        x.gridy = 8;
        p1.add(ltrama,x);
    
        x.gridx = 1;
        x.gridy = 9;
        x.gridheight = 2;
        p1.add(trama,x);

        add(p1,BorderLayout.CENTER);

        
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

    public JTextField getNome() {
        return nome;
    }

    public JTextField getAutore() {
        return autore;
    }

    public JTextField getGenere() {
        return genere;
    }

    public JTextField getNpag() {
        return npag;
    }

    public void setImmagineCopertina(){
        File fileicon = new File("Images/Aggiungi.png");
        ImageIcon icon = new ImageIcon(fileicon.getAbsolutePath());
        copertina.setIcon(new ImageIcon(icon.getImage().getScaledInstance(285, 370, 5)));
        copertina.setOpaque(false);
        copertina.setBorderPainted(false);
        copertina.setContentAreaFilled(false);

    }

}
