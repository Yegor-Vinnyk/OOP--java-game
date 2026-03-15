import javax.swing.JFrame;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Angry Birds");
        Game game = new Game();


        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(game, BorderLayout.CENTER);
    }
}
