import java.awt.event.*;
import java.io.IOException;

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
    }

    public void ActionListener(){
        ActionListener cambiaPagina = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.cambiaPagina();
                if(e.getSource() == finestra.getHome().getAggiungiRead()){  //controllo quale pulsante è stato premuto

                    finestra.getAddPage().getRead().setSelected(true);  
                    finestra.getAddPage().getReading().setSelected(false);
                    finestra.getAddPage().getToRead().setSelected(false);

                }else if(e.getSource() == finestra.getHome().getAggiungiReading()){

                    finestra.getAddPage().getReading().setSelected(true);
                    finestra.getAddPage().getRead().setSelected(false);
                    finestra.getAddPage().getToRead().setSelected(false);

                }else if(e.getSource() == finestra.getHome().getAggiungiToRead()){

                    finestra.getAddPage().getToRead().setSelected(true);
                    finestra.getAddPage().getReading().setSelected(false);
                    finestra.getAddPage().getRead().setSelected(false);

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
                model.aggiungiLibro();
                model.leggiLibro();
            }catch( IOException | ClassNotFoundException x){
                x.printStackTrace();
            }
        }
        };

        ActionListener readActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                finestra.getAddPage().CheckboxRead();
            }
        };

        ActionListener readingActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                finestra.getAddPage().CheckboxReading();
            }
        };

        ActionListener toReadActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                finestra.getAddPage().CheckboxToRead();
            }
        };  

        finestra.getHome().getAggiungiRead().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiReading().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiToRead().addActionListener(cambiaPagina);
        finestra.getHome().getProfileButton().addActionListener(cambiaImmagineProfilo);
        
        finestra.getAddPage().getIndietro().addActionListener(cambiaPagina);
        finestra.getAddPage().getCopertina().addActionListener(cambiaImmagineCopertina);
        finestra.getAddPage().getAggiungi().addActionListener(aggiungiLibro);
        finestra.getAddPage().getRead().addActionListener(readActionListener);
        finestra.getAddPage().getReading().addActionListener(readingActionListener);
        finestra.getAddPage().getToRead().addActionListener(toReadActionListener);
    }
    
}
