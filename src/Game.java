
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application /*implements Runnable*/ {

  /*  private Level currentLevel;
    private PhysicsEngine physicsEngine;
    private inputHanler inputHanler;*/
    /*private boolean isRunning;*/

    private StackPane root;
    private Pane currentScreen;


    @Override
    public void start(Stage stage) {

        root = new StackPane();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());


        selectMenuScreen();
        stage.setTitle("Angry Birds");
        stage.setFullScreen(true);

        ImageView background = new ImageView(new Image(getClass().getResource("/images/background.jpg").toExternalForm()));

        background.fitWidthProperty().bind(scene.widthProperty());
        background.fitHeightProperty().bind(scene.heightProperty());
        background.setPreserveRatio(false);

        root.getChildren().add(background);
        selectMenuScreen();
        stage.setScene(scene);
        stage.setFullScreen(true);

        stage.show();
        startGameLoop();

    }

    private void startGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
               /* update();
                render();*/
            }
        }.start();
    }


    public void setScreen(Pane screen) {

        if (currentScreen != null) {
            root.getChildren().remove(currentScreen);
        }
        currentScreen = screen;

        screen.prefWidthProperty().bind(root.widthProperty());
        screen.prefHeightProperty().bind(root.heightProperty());

        root.getChildren().add(screen);

    }

    public void selectMenuScreen() {
        setScreen(new MenuScreen(this));


    }

    public void selectLevelScreen() {
        setScreen(new LevelScreen(this));


    }

    public void levelScreen() {
        setScreen(new GameScreen(this));


    }


}
