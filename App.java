
public class App{
    public static void main(String args[]){
        Home home = new Home("Libreria");
        Aggiungi addPage = new Aggiungi("Aggiungi libro");
        Controller controller = new Controller(addPage, home);
        controller.ActionListener();
        Model model = new Model(addPage, home);
        home.setVisible(true);

    }
}