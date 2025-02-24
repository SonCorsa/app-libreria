
public class App{
    public static void main(String args[]){
        Libreria libri= new Libreria();
        JFramePrincipale finestra = new JFramePrincipale();
        Home home = new Home(finestra);
        Aggiungi addPage = new Aggiungi(finestra);
        Model model = new Model(finestra,addPage, home,libri);
        Controller controller = new Controller(finestra,addPage, home,libri);
        controller.ActionListener();
        finestra.setVisible(true);

    }
}