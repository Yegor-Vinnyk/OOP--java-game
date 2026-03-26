import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class PauseOverlay extends StackPane {

    public PauseOverlay(Runnable resume, Runnable exit, Game game) {
        this.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7)");
        this.setVisible(false);



        Button resumeButton = new Button("RESUME");
        Button exitButton = new Button("EXIT");

        VBox menuBox = new VBox(20);
        menuBox.setAlignment(Pos.CENTER );

        Label title = new Label("GAME PAUSED");
        title.setStyle("-fx-text-fill: white;" + "-fx-font-size: 50;" + "-fx-font-weight: bold;");

        resumeButton.getStyleClass().addAll("button", "button--pause");
        exitButton.getStyleClass().addAll("button", "button--pause");

        resumeButton.setOnMouseClicked(e -> {
            resume.run();
        });

        exitButton.setOnMouseClicked(e -> {
            game.selectLevelScreen();
        });

        menuBox.getChildren().addAll(title, resumeButton, exitButton);
        getChildren().addAll(menuBox);

    }

    public void show() {
        this.setVisible(true);
    }

    public void hide() {
        this.setVisible(false);
    }
}
