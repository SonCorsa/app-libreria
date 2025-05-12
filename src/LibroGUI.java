import java.awt.*;
import java.io.File;
import javax.swing.*;

import ComponentiRotondi.RoundedTextArea;
import ComponentiRotondi.RoundedTextField;

public class LibroGUI extends JPanel{

    private JButton salva,indietro,copertina;
    private JTextField nome,autore,genere,npag;
    private JTextArea trama;
    private JLabel lnome,lautore,lgenere,lnpag,ltrama;
    private JPanel indietroPanel,aggiungiPanel,p1;
    private GridBagConstraints c;
    private JCheckBox read,reading,toRead;
    private Libri l; //libro da modificare

    public LibroGUI(JFramePrincipale finestra,Libri l){
        this.l = l;
        setLayout(new BorderLayout());
        //istanzio il panel

        //istanzio JButton
        salva = new JButton("salva");
        indietro = new JButton();
        copertina = new JButton();

        //setto l'immagine del bottone copertina
        setImmagineCopertina();
        setImmagineBottone(indietro, "Images/Freccia.png", 100, 60);
       

        //istanzio JTextField
        nome = new RoundedTextField(10,10);
        autore = new RoundedTextField(10,10);
        genere = new RoundedTextField(10,10);
        npag = new RoundedTextField(10,10);
        trama = new RoundedTextArea(10,10);
        trama.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        trama.setLineWrap(true);

        if(l != null) {
            nome.setText(l.getNome());
            autore.setText(l.getAutore());
            genere.setText(l.getGenere());
            npag.setText(String.valueOf(l.getPagine()));
            trama.setText(l.getTrama());
        }
        
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
        salva.setPreferredSize(new Dimension(200,45));
    
        //TASTI INDIETRO E AGGIUNGI
        indietroPanel.add(indietro);
        aggiungiPanel.add(salva);
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
        x.insets = new Insets(0,0,0,200);
        x.anchor = GridBagConstraints.PAGE_START;
        p1.add(lnome,x);
        
        x.gridx = 1;
        x.gridy = 1;
        x.insets = new Insets(0,0,0,0);
        p1.add(nome,x);

        //LABEL AUTORE E TEXTFIELD AUTORE
        x.gridx = 1;
        x.gridy = 2;
        x.insets = new Insets(0,0,0,200);
        p1.add(lautore,x);

        x.gridx = 1;
        x.gridy = 3;
        x.insets = new Insets(0,0,0,0);
        p1.add(autore,x);

        //LABEL GENERE E TEXTFIELD GENERE
        x.gridx = 1;
        x.gridy = 4;
        x.insets = new Insets(0,0,0,200);
        p1.add(lgenere,x);

        x.gridx = 1;
        x.gridy = 5;
        x.insets = new Insets(0,0,0,0);
        p1.add(genere,x);

        //LABEL NUMERO PAGINE E TEXTFIELD NUMERO PAGINE
        x.gridx = 1;
        x.gridy = 6;
        x.insets = new Insets(0,0,0,150);
        p1.add(lnpag,x);

        x.gridx = 1;
        x.gridy = 7;
        x.insets = new Insets(0,0,0,0);
        p1.add(npag,x);

        //LABEL TRAMA E TEXTFIELD TRAMA
        x.gridx = 1;
        x.gridy = 8;
        x.insets = new Insets(0,0,0,200);
        p1.add(ltrama,x);
    
        x.gridx = 1;
        x.gridy = 9;
        x.insets = new Insets(0,0,0,0);
        x.gridheight = 2;
        p1.add(trama,x);
        add(p1,BorderLayout.CENTER);
    }

    //get dei JButton
    public JButton getSalva() {
        return salva;
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
    public Libri getLibro(){
        return l;
    }

    public void setImmagineCopertina(){
        try{

            ImageIcon icon = new ImageIcon(l.getImmagine());
            copertina.setIcon(new ImageIcon(icon.getImage().getScaledInstance(285, 370, 5)));
            copertina.setOpaque(false);
            copertina.setBorderPainted(false);
            copertina.setContentAreaFilled(false);
        }catch(Exception e){
            System.out.println("Immagine non trovata");
        }
    }
    
    public void setImmagineBottone(JButton b,String path, int x ,int y){
        File fileicon = new File(path);
        ImageIcon icon = new ImageIcon(fileicon.getAbsolutePath());
        b.setIcon(new ImageIcon(icon.getImage().getScaledInstance(x, y, 5)));
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
    }


}
