import java.awt.*;
import java.io.File;
import javax.swing.*;

;

public class LibroGUI extends JPanel{

    private JButton aggiungi,indietro,copertina;
    private JLabel lnome,lautore,lgenere,lnpag,ltrama;
    private JPanel indietroPanel,aggiungiPanel,p1;
    private GridBagConstraints c;
    
    public LibroGUI(JFramePrincipale finestra){
        setLayout(new BorderLayout());
        //istanzio il panel

        //istanzio JButton
        aggiungi = new JButton("aggiungi");
        indietro = new JButton();
        copertina = new JButton();

        //setto l'immagine del bottone copertina
        setImmagineCopertina();
        setImmagineBottone(indietro, "Images/Freccia.png", 100, 60);
       
        //istanzio JLabel
        lnome = new JLabel("Nome");
        lautore = new JLabel("Autore");
        lgenere = new JLabel("Genere");
        lnpag = new JLabel("Numero pagine");
        ltrama= new JLabel("Trama");

        //istanzio JPanel
        indietroPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1 = new JPanel(new GridBagLayout());
    
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
        x.insets = new Insets(0,0,0,200);
        x.anchor = GridBagConstraints.PAGE_START;
        p1.add(lnome,x);
        

        //LABEL AUTORE E TEXTFIELD AUTORE
        x.gridx = 1;
        x.gridy = 2;
        x.insets = new Insets(0,0,0,200);
        p1.add(lautore,x);

        //LABEL GENERE E TEXTFIELD GENERE
        x.gridx = 1;
        x.gridy = 4;
        x.insets = new Insets(0,0,0,200);
        p1.add(lgenere,x);


        //LABEL NUMERO PAGINE E TEXTFIELD NUMERO PAGINE
        x.gridx = 1;
        x.gridy = 6;
        x.insets = new Insets(0,0,0,150);
        p1.add(lnpag,x);


        //LABEL TRAMA E TEXTFIELD TRAMA
        x.gridx = 1;
        x.gridy = 8;
        x.insets = new Insets(0,0,0,200);
        p1.add(ltrama,x);
    
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


    public void setImmagineCopertina(){
        File fileicon = new File("Images/Aggiungi.png");
        ImageIcon icon = new ImageIcon(fileicon.getAbsolutePath());
        copertina.setIcon(new ImageIcon(icon.getImage().getScaledInstance(285, 370, 5)));
        copertina.setOpaque(false);
        copertina.setBorderPainted(false);
        copertina.setContentAreaFilled(false);
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

