import java.awt.Desktop.Action;
import java.awt.event.*;
import java.io.*;
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
        //finestra.getHome().getReadPanel().removeAll();
        //finestra.getHome().getReadingPanel().removeAll();
        //finestra.getHome().getToReadPanel().removeAll();
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
        ActionListener salva = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.salvaLibro(rif,finestra.getLibroGUI());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
        
        ActionListener apriLibro = new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                for(Libri l: libri.getLibri()){   
                    if(b.equals(l.getButton())){
                        System.out.println("Apro");
                        rif=l;
                        model.apriLibro(l);
                        finestra.getLibroGUI().getIndietro().addActionListener(cambiaPagina);
                        finestra.getLibroGUI().getSalva().addActionListener(salva);
                    }                    
                }
            }
        };
        
        ActionListener aggiungiLibro= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    model.aggiungiLibro(x);
                    model.leggiLibro();
                    // AGGIORNA LA VARIABILE libri DEL CONTROLLER!
                    setLibreria(model.getLibreria());
                    // Riassocia gli ActionListener ai nuovi bottoni
                    for(JButton b: finestra.getHome().getLibriButtonsRead()){
                        b.addActionListener(apriLibro);
                    }
                    for(JButton b: finestra.getHome().getLibriButtonsReading()){
                        b.addActionListener(apriLibro);
                    }
                    for(JButton b: finestra.getHome().getLibriButtonsToRead()){
                        b.addActionListener(apriLibro);
                    }
                }catch( Exception x){
                    x.printStackTrace();
                }
            }
        };

        ActionListener scorrimentoReading = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scorrimentoReading();
                 for(JButton b: finestra.getHome().getLibriButtonsReading()){
                    b.addActionListener(apriLibro);
                }
            }
        };

        ActionListener scorrimentoRead = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scorrimentoRead();
                for(JButton b: finestra.getHome().getLibriButtonsRead()){
                    b.addActionListener(apriLibro);
                }
            }
        };

        ActionListener scorrimentoToRead = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scorrimentoToRead();
                for(JButton b: finestra.getHome().getLibriButtonsToRead()){
                    b.addActionListener(apriLibro);
                }
            }
        };

        ActionListener scorrimentoInv = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scorrimentoInvReading();
                for(JButton b: finestra.getHome().getLibriButtonsReading()){
                    b.addActionListener(apriLibro);
                }
            }
        };

        ActionListener scorrimentoInvRead = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scorrimentoInvRead();
                for(JButton b: finestra.getHome().getLibriButtonsRead()){
                    b.addActionListener(apriLibro);
                }
            }
        };

        ActionListener scorrimentoInvToRead = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scorrimentoInvToRead();
                for(JButton b: finestra.getHome().getLibriButtonsToRead()){
                    b.addActionListener(apriLibro);
                }
            }
        };
        

        for(JButton b: finestra.getHome().getLibriButtonsRead()){
            b.addActionListener(apriLibro);
        }
        for(JButton b: finestra.getHome().getLibriButtonsReading()){
            b.addActionListener(apriLibro);
        }
        for(JButton b: finestra.getHome().getLibriButtonsToRead()){
            b.addActionListener(apriLibro);
        }
        finestra.getHome().getAggiungiRead().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiReading().addActionListener(cambiaPagina);
        finestra.getHome().getAggiungiToRead().addActionListener(cambiaPagina);
        finestra.getHome().getProfileButton().addActionListener(cambiaImmagineProfilo);
        
        finestra.getAddPage().getAggiungi().addActionListener(aggiungiLibro);
        finestra.getAddPage().getIndietro().addActionListener(cambiaPagina);
        finestra.getAddPage().getCopertina().addActionListener(cambiaImmagineCopertina);

        finestra.getHome().getScorriButtonReading().addActionListener(scorrimentoReading);
        finestra.getHome().getScorriInvReading().addActionListener(scorrimentoInv);
        finestra.getHome().getScorriButtonRead().addActionListener(scorrimentoRead);
        finestra.getHome().getScorriInvRead().addActionListener(scorrimentoInvRead);
        finestra.getHome().getScorriButtonToRead().addActionListener(scorrimentoToRead);
        finestra.getHome().getScorriInvToRead().addActionListener(scorrimentoInvToRead);

    }

    public Libreria getLibreria(){
        return this.libri;
    }
    public void setLibreria(Libreria l){
        this.libri=l;
    }
}
