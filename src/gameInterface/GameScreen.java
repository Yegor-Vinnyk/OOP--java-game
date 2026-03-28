package gameInterface;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.SVGPath;
import javafx.scene.paint.Color;
import gameInterface.PauseOverlay;
import gameEngine.Game;


public class GameScreen extends Pane {
    private PauseOverlay pauseMenu;

    public GameScreen(Game game) {
        setPickOnBounds(false); // Let events pass through to the canvas if not handled by buttons

        Button pauseButton = new Button();
        SVGPath svgIconPause = new SVGPath();

        svgIconPause.setContent("M5.5 3.5A1.5 1.5 0 0 1 7 5v6a1.5 1.5 0 0 1-3 0V5a1.5 1.5 0 0 1 1.5-1.5m5 0A1.5 1.5 0 0 1 12 5v6a1.5 1.5 0 0 1-3 0V5a1.5 1.5 0 0 1 1.5-1.5");
        svgIconPause.setFill(Color.WHITE);
        svgIconPause.setScaleX(3);
        svgIconPause.setScaleY(3);
        pauseButton.setGraphic(svgIconPause);

        pauseButton.getStyleClass().addAll("button", "button--round");
        pauseButton.setLayoutX(10);
        pauseButton.setLayoutY(10);

        pauseMenu = new PauseOverlay(
                () -> resumeGame(),
                game
        );


        pauseMenu.prefWidthProperty().bind(this.widthProperty());
        pauseMenu.prefHeightProperty().bind(this.heightProperty());

        getChildren().addAll(pauseButton, pauseMenu);

        pauseButton.setOnMouseClicked(e -> {
            pauseMenu.show();
        });
    }

    private void resumeGame() {
        pauseMenu.hide();
    }

    private void pauseGame() {
        pauseMenu.show();
    }

    private void quitToMenu() {

        // switch scene logic
    }

}
