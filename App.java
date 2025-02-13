
public class App{
    public static void main(String args[]){
        Home home = new Home("Libreria");
        Aggiungi addPage = new Aggiungi("Aggiungi libro");
        Model model = new Model(addPage, home);
        Controller controller = new Controller(addPage, home);
        controller.ActionListener();
        home.setVisible(true);

    }
}