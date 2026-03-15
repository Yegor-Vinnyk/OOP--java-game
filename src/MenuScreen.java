import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel {

    public MenuScreen(Game game) {

        JButton startButton = new JButton("Start");
        setOpaque(false);

        startButton.setBackground(Color.YELLOW);
        startButton.setForeground(Color.WHITE);



        startButton.setPreferredSize(new Dimension(200, 100));
        startButton.setFont(new Font("Arial", Font.BOLD, 25));
        startButton.addActionListener(e -> {
            game.showScreen(new LevelScreen(game));
        });
        add(startButton, new GridBagConstraints());
    }
}
