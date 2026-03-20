
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;


public class MenuScreen extends Pane {

    public MenuScreen(Game game) {


        Button playButton = new Button("Play");
        Button exitButton = new Button("");

        playButton.getStyleClass().addAll("button", "button--main");
        exitButton.getStyleClass().addAll("button", "button--exit");




        exitButton.layoutXProperty().bind(widthProperty().subtract(90));
        exitButton.setLayoutY(10);

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





        getChildren().add(playButton);
        getChildren().add(titleImage);
        getChildren().add(exitButton);


    }

}
