import java.awt.event.*;
import java.io.IOException;
import javax.swing.JButton;

public class Controller {
    private JFramePrincipale finestra;
    private Model model;
    private Libreria libri;
    private int x;
    private Libri rif;

    public Controller(JFramePrincipale finestra,Libreria libri,Model model){
        this.finestra=finestra;
        this.libri=libri;
        this.model=model;
    }
    
    public void Setup() throws IOException, ClassNotFoundException{
        finestra.getHome().getReadPanel().removeAll();
        finestra.getHome().getReadingPanel().removeAll();
        finestra.getHome().getToReadPanel().removeAll();
        model.leggiLibro();
        this.ActionListener();
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
                System.out.println(x);
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

        
        ActionListener salva = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.salvaLibro(rif);
                System.out.print(rif+"porocdio");
            }
        };
        
        ActionListener apriLibro = new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                for(Libri l: libri.getLibri()){   
                    if(b.equals(l.getButton())){
                        rif=l;
                        System.out.println(l);
                        System.out.println(rif);
                        model.apriLibro(l).getIndietro().addActionListener(cambiaPagina);
                        model.apriLibro(l).getSalva().addActionListener(salva);
                    }
                    
                }
            }
        };
        
        for(JButton b: finestra.getHome().getLibriButtonsRead()){
            b.addActionListener(apriLibro);
        }
        finestra.getHome().getAggiungiRead().addActionListener(cambiaPagina);
        for(JButton b: finestra.getHome().getLibriButtonsReading()){
            b.addActionListener(apriLibro);
        }
        for(JButton b: finestra.getHome().getLibriButtonsToRead()){
            b.addActionListener(apriLibro);
        }
        finestra.getHome().getAggiungiReading().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiToRead().addActionListener(cambiaPagina);
        finestra.getHome().getProfileButton().addActionListener(cambiaImmagineProfilo);
        
        finestra.getAddPage().getIndietro().addActionListener(cambiaPagina);
        finestra.getAddPage().getCopertina().addActionListener(cambiaImmagineCopertina);
        finestra.getAddPage().getAggiungi().addActionListener(aggiungiLibro);



        
    }

    public Libreria getLibreria(){
        return this.libri;
    }
    public void setLibreria(Libreria l){
        this.libri=l;
    }
}
