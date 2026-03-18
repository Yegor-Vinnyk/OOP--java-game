
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;


public class MenuScreen extends Pane {

    public MenuScreen(Game game) {


        Button playButton = new Button("Play");

        ImageView titleImage = new ImageView(new Image(getClass().getResource("/images/title.png").toExternalForm()));

        titleImage.setFitHeight(250);
        titleImage.layoutXProperty().bind(widthProperty().divide(2).subtract(450));
        titleImage.setLayoutY(200);

        playButton.layoutXProperty().bind(widthProperty().divide(2).subtract(85));
        playButton.layoutYProperty().bind(heightProperty().divide(2).subtract(20));

        playButton.setOnMouseClicked(e -> {
            game.selectLevelScreen();
        });

        playButton.setStyle("-fx-background-color: FAEE00;" + "-fx-text-fill: white;" + "-fx-border-color: none;" + "-fx-border-radius: 10;" + "-fx-background-radius: 10;" + "-fx-pref-height: 120;" + "-fx-pref-width: 200;" + "-fx-font-size: 27;" + "-fx-font-weight: bold;");

        getChildren().add(playButton);
        getChildren().add(titleImage);


    }

}
