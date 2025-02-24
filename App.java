
public class App{
    public static void main(String args[]){
        Libreria libri= new Libreria();
        Home home = new Home("Libreria");
        Aggiungi addPage = new Aggiungi("Aggiungi libro");
        Model model = new Model(addPage, home,libri);
        Controller controller = new Controller(addPage, home,libri);
        controller.ActionListener();
        home.setVisible(true);

    }
}