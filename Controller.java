import java.awt.event.*;

public class Controller {
    private Aggiungi addPage;
    private Home home;
    private Model model;

    public Controller(Aggiungi addPage, Home home){
        this.addPage=addPage;
        this.home=home;
        model=new Model(addPage,home);
    }

    public void ActionListener(){
        ActionListener cambiaPagina = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                model.cambiaPagina();
            }
        };

        home.getAggiungiRead().addActionListener(cambiaPagina);
        home.getAggiungiReading().addActionListener(cambiaPagina);
        home.getAggiungiToRead().addActionListener(cambiaPagina);
        addPage.getIndietro().addActionListener(cambiaPagina);

    }
}
