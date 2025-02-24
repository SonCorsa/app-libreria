import java.awt.event.*;

public class Controller {
    private JFramePrincipale finestra;
    private Aggiungi addPage;
    private Home home;
    private Model model;
    private Libreria libri;

    public Controller(JFramePrincipale finestra,Aggiungi addPage, Home home,Libreria libri){
        this.finestra=finestra;
        this.addPage=addPage;
        this.home=home;
        this.libri=libri;
        model=new Model(finestra,addPage,home,libri);
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
                model.aggiungiLibro();
            }
        };

        finestra.getHome().getAggiungiRead().addActionListener(cambiaPagina);
        home.getAggiungiReading().addActionListener(cambiaPagina);
        home.getAggiungiToRead().addActionListener(cambiaPagina);
        addPage.getIndietro().addActionListener(cambiaPagina);
        home.getProfileButton().addActionListener(cambiaImmagineProfilo);
        addPage.getCopertina().addActionListener(cambiaImmagineCopertina);
        addPage.getAggiungi().addActionListener(aggiungiLibro);
    }
    
}
