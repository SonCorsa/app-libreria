import java.awt.*;
import javax.swing.*;

;

public class LibroGUI extends JPanel{

    private JButton indietro,salva;
    private JLabel lnome,lautore,lgenere,lnpag,ltrama,copertina;
    private JPanel p1,p2,p3;
    
    public LibroGUI(JFramePrincipale finestra,Libri l){
        setLayout(new BorderLayout());
        //istanzio il panel
        p1=new JPanel(new GridLayout(1,2 ));
        p2=new JPanel();
        p3=new JPanel(new GridLayout(4,1 ));
        //istanzio i bottoni
        indietro=new JButton("⬅️");
        salva= new JButton("SALVA");
        
        //instanzio i label
        copertina=new JLabel();
        p2.add(copertina,BorderLayout.EAST);
        lautore=new JLabel(l.getAutore());
        lnome=new JLabel(l.getNome());
        lgenere=new JLabel(l.getGenere());
        lnpag=new JLabel(String.format("%d",l.getPagine()));
        ltrama=new JLabel(l.getTrama());
        p3.add(lautore);
        p3.add(lnome);
        p3.add(lgenere);
        p3.add(lnpag);
        p3.add(ltrama);
        
        //operazioni finali
        p1.add(p2);
        p1.add(p3);
        add(p1);

    }

    public JButton getIndietro() {
        return indietro;
    }

    public JLabel getLnome() {
        return lnome;
    }

    public JLabel getLautore() {
        return lautore;
    }

    public JLabel getLgenere() {
        return lgenere;
    }

    public JLabel getLnpag() {
        return lnpag;
    }

    public JLabel getLtrama() {
        return ltrama;
    }

    public JLabel getCopertina() {
        return copertina;
    }

    public JPanel getP1() {
        return p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public JPanel getP3() {
        return p3;
    }

}
