import java.awt.BorderLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ImageUploaderSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carica immagine");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel("Nessuna immagine selezionata", SwingConstants.CENTER);
        JButton uploadButton = new JButton("Carica immagine");

        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                imageLabel.setIcon(new ImageIcon(imageIcon.getImage()));
                imageLabel.setText(""); // Rimuove il testo
            }
        });

        frame.add(imageLabel, BorderLayout.CENTER);
        frame.add(uploadButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}