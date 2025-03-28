import java.awt.event.*;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Controller {
    private JFramePrincipale finestra;
    private Model model;
    private Libreria libri;

    public Controller(JFramePrincipale finestra,Libreria libri) throws Exception{
        this.finestra=finestra;
        this.libri=libri;
        model=new Model(finestra,libri);
        this.ActionListener();
        this.Setup();
    }

    private void Setup() throws IOException, ClassNotFoundException{
        model.leggiLibro();
        /*for(Libri l : libri.getLibri()){
            finestra.getLibroGUI().getLautore().setText(l.autore);
            finestra.getLibroGUI().getLgenere().setText(l.genere);
            finestra.getLibroGUI().getLnome().setText(l.nome);
            finestra.getLibroGUI().getLnpag().setText(String.valueOf(l.pagine));
            ImageIcon copertina= new ImageIcon(l.getImmagine());
            finestra.getLibroGUI().getCopertina().setIcon(copertina);
        }*/
    }

    public void ActionListener(){
        ActionListener cambiaPagina = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.cambiaPagina();
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
                model.aggiungiLibro();
                model.leggiLibro();
            }catch( IOException | ClassNotFoundException x){
                x.printStackTrace();
            }
        }
        };

        finestra.getHome().getAggiungiRead().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiReading().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiToRead().addActionListener(cambiaPagina);
        finestra.getHome().getProfileButton().addActionListener(cambiaImmagineProfilo);
        
        finestra.getAddPage().getIndietro().addActionListener(cambiaPagina);
        finestra.getAddPage().getCopertina().addActionListener(cambiaImmagineCopertina);
        finestra.getAddPage().getAggiungi().addActionListener(aggiungiLibro);
    }
    
}
