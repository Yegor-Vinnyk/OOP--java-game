import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.SVGPath;
import javafx.scene.paint.Color;

public class LevelScreen extends Pane {


    public LevelScreen(Game game) {

        Button level1Button = new Button("1");
        Button level2Button = new Button("2");
        Button level3Button = new Button("3");
        Button level4Button = new Button("4");
        Button level5Button = new Button("5");
        Button backButton = new Button("");

        level1Button.getStyleClass().addAll("button", "button--level");
        level2Button.getStyleClass().addAll("button", "button--level");
        level3Button.getStyleClass().addAll("button", "button--level");
        level4Button.getStyleClass().addAll("button", "button--level");
        level5Button.getStyleClass().addAll("button", "button--level");
        backButton.getStyleClass().addAll("button", "button--round");

        SVGPath svgIconBack = new SVGPath();
        svgIconBack.setScaleX(2.5);
        svgIconBack.setScaleY(2.5);
        svgIconBack.setContent("M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8");
        svgIconBack.setFill(Color.WHITE);

        backButton.setGraphic(svgIconBack);
        backButton.setLayoutX(10);
        backButton.setLayoutY(10);

        backButton.setOnMouseClicked(e -> {
            game.selectMenuScreen();
        });

        level1Button.setLayoutX(470);
        level1Button.setLayoutY(350);


        level2Button.setLayoutX(880);
        level2Button.setLayoutY(350);


        level3Button.setLayoutX(1290);
        level3Button.setLayoutY(350);


        level4Button.setLayoutX(675);
        level4Button.setLayoutY(550);


        level5Button.setLayoutX(1085);
        level5Button.setLayoutY(550);


        level1Button.setOnMouseClicked(e -> {
            game.levelScreen();
        });

        level2Button.setOnMouseClicked(e -> {
            game.levelScreen();
        });

        level3Button.setOnMouseClicked(e -> {
            game.levelScreen();
        });

        level4Button.setOnMouseClicked(e -> {
            game.levelScreen();
        });

        level5Button.setOnMouseClicked(e -> {
            game.levelScreen();
        });


        getChildren().add(level1Button);
        getChildren().add(level2Button);
        getChildren().add(level3Button);
        getChildren().add(level4Button);
        getChildren().add(level5Button);
        getChildren().add(backButton);


    }


}
