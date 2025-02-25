
public class App{
    public static void main(String args[]){
        Libreria libri= new Libreria();
        JFramePrincipale finestra = new JFramePrincipale();
        Model model = new Model(finestra,libri);
       
        Controller controller = new Controller(finestra,libri);
        controller.ActionListener();
        finestra.setVisible(true);

    }
}