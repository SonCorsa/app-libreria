import java.awt.event.*;
import java.io.IOException;

public class Controller {
    private JFramePrincipale finestra;
    private Model model;
    private Libreria libri;

    public Controller(JFramePrincipale finestra,Libreria libri){
        this.finestra=finestra;
        this.libri=libri;
        model=new Model(finestra,libri);
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
                }catch(IOException x){
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
