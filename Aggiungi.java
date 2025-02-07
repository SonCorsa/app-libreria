import java.awt.*;
import javax.swing.*;

public class Aggiungi extends JFrame{
    private JLabel prova;

    public Aggiungi(String titolo){
        super(titolo);
        prova = new JLabel("prova");
        add(prova,BorderLayout.CENTER);
        setSize(600,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
