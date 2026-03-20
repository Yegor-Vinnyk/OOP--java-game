
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;


public class MenuScreen extends Pane {

    public MenuScreen(Game game) {


        Button playButton = new Button("Play");
        Button exitButton = new Button("HUI");

        exitButton.layoutXProperty().bind(widthProperty().subtract(90));
        exitButton.setLayoutY(10);

        exitButton.setStyle("-fx-background-color: FAEE00;" + "-fx-text-fill: white;" + "-fx-border-color: none;" + "-fx-border-radius: 50;" + "-fx-background-radius: 50;" + "-fx-pref-height: 80;" + "-fx-pref-width: 80;");
        exitButton.setOnMouseClicked(e -> {
            System.exit(0);
        });

        ImageView titleImage = new ImageView(new Image(getClass().getResource("/images/title.png").toExternalForm()));

        titleImage.setFitHeight(250);
        titleImage.layoutXProperty().bind(widthProperty().divide(2).subtract(450));
        titleImage.setLayoutY(200);

        playButton.layoutXProperty().bind(widthProperty().divide(2).subtract(85));
        playButton.layoutYProperty().bind(heightProperty().divide(2).subtract(20));

        playButton.setOnMouseClicked(e -> {
            game.selectLevelScreen();
        });

        playButton.setStyle("-fx-background-color: FAEE00;" + "-fx-text-fill: white;" + "-fx-border-color: none;" + "-fx-border-radius: 10;" + "-fx-background-radius: 10;" + "-fx-pref-height: 120;" + "-fx-pref-width: 200;" + "-fx-font-size: 30;" + "-fx-font-weight: bold;");

        getChildren().add(playButton);
        getChildren().add(titleImage);
        getChildren().add(exitButton);


    }

}
