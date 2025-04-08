import java.awt.event.*;
import java.io.IOException;
import java.util.Set;

import javax.print.DocFlavor.SERVICE_FORMATTED;
import javax.swing.JButton;

public class Controller {
    private JFramePrincipale finestra;
    private Model model;
    private Libreria libri;
    private int x;

    public Controller(JFramePrincipale finestra,Libreria libri) throws Exception{
        this.finestra=finestra;
        this.libri=libri;
        this.model=new Model(finestra,libri);
        this.ActionListener();
    }
    
    public void Setup() throws IOException, ClassNotFoundException{
        finestra.getHome().getReadPanel().removeAll();
        finestra.getHome().getReadingPanel().removeAll();
        finestra.getHome().getToReadPanel().removeAll();
        model.leggiLibro();
    }

    //?DA CAMBIARE
    public void ActionListener(){
        ActionListener cambiaPagina = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.cambiaPagina();
                if(e.getSource() == finestra.getHome().getAggiungiRead()){  //controllo quale pulsante è stato premuto
                    x = 1;

                }else if(e.getSource() == finestra.getHome().getAggiungiReading()){
                    x = 2;

                }else if(e.getSource() == finestra.getHome().getAggiungiToRead()){
                    x = 3;

                }
            }
        };

        ActionListener cambiaImmagineProfilo = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.cambiaImmagineProfilo();
            }
        };
        
        ActionListener cambiaImmagineCopertina = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.cambiaImmagineCopertina();
            }
        };

        ActionListener aggiungiLibro= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            try{
                model.aggiungiLibro(x);
                System.out.println("Aggiunto libro alla libreria"+1);
                Setup();
            }catch( Exception x){
                x.printStackTrace();
            }
        }
        };

        ActionListener apriLibro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                model.apriLibro(b);
            }
        };

        finestra.getHome().getAggiungiRead().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiReading().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiToRead().addActionListener(cambiaPagina);
        finestra.getHome().getProfileButton().addActionListener(cambiaImmagineProfilo);
        
        finestra.getAddPage().getIndietro().addActionListener(cambiaPagina);
        finestra.getAddPage().getCopertina().addActionListener(cambiaImmagineCopertina);
        finestra.getAddPage().getAggiungi().addActionListener(aggiungiLibro);

        for(JButton b: finestra.getHome().getLibriButtonsRead()){
            b.addActionListener(apriLibro);
        }

        for(JButton b: finestra.getHome().getLibriButtonsReading()){
            b.addActionListener(apriLibro);
        }

        for(JButton b: finestra.getHome().getLibriButtonsToRead()){
            b.addActionListener(apriLibro);
        }
    }
    
}
