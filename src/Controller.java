import java.awt.event.*;
import java.io.IOException;

public class Controller {
    private JFramePrincipale finestra;
    private Model model;
    private Libreria libri;
    private int x;

    public Controller(JFramePrincipale finestra,Libreria libri) throws Exception{
        this.finestra=finestra;
        this.libri=libri;
        model=new Model(finestra,libri);
        this.ActionListener();
        this.Setup();
    }

    private void Setup() throws IOException, ClassNotFoundException{
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
                Setup();
            }catch( Exception x){
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
