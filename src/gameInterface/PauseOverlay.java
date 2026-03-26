package gameInterface;

import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import gameEngine.Game;
import levels.Level;

public class PauseOverlay extends StackPane {

    public PauseOverlay(Runnable resume, Game game) {
        this.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7)");
        this.setVisible(false);

        this.setPrefSize(getWidth(), getHeight());
        this.setOnMouseClicked(Event::consume);

        Button resumeButton = new Button("RESUME");
        Button exitButton = new Button("EXIT");

        VBox menuBox = new VBox(20);
        menuBox.setAlignment(Pos.CENTER);

        Label title = new Label("GAME PAUSED");
        title.setStyle("-fx-text-fill: white;" + "-fx-font-size: 50;" + "-fx-font-weight: bold;");

        resumeButton.getStyleClass().addAll("button", "button--pause");
        exitButton.getStyleClass().addAll("button", "button--pause");

        resumeButton.setOnMouseClicked(e -> {
            resume.run();
            hide();
        });

        exitButton.setOnMouseClicked(e -> {
            game.exitLevel();
        });

        menuBox.getChildren().addAll(title, resumeButton, exitButton);
        getChildren().addAll(menuBox);

    }

    public void show() {
        this.setVisible(true);
        this.toFront();
    }

    public void hide() {
        this.setVisible(false);
    }
}
