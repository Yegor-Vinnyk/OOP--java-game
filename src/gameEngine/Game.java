package gameEngine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import gameInterface.GameScreen;
import gameInterface.MenuScreen;
import gameInterface.LevelScreen;
import levels.Level1;
import levels.Level;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import objects.Bird;
import gameEngine.InputHandler;
import gameEngine.PhysicsEngine;
import objects.Slingshot;
import objects.Blue;

import java.lang.reflect.InvocationTargetException;


public class Game extends Application /*implements Runnable*/ {

    private Level currentLevel;
    private GraphicsContext gc;
    private Canvas canvas;
    private Bird currentBird;
    private PhysicsEngine physicsEngine;
    private InputHandler inputHandler;
    /*private boolean isRunning;*/

    private Slingshot slingshot;
    private StackPane root;
    private Pane currentScreen;


    @Override
    public void start(Stage stage) {

        root = new StackPane();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());

        canvas = new Canvas();
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());
        gc = canvas.getGraphicsContext2D();

        inputHandler = new InputHandler(canvas, this);
        slingshot = new Slingshot(430, 930, 100, 150);
        physicsEngine = new PhysicsEngine();


        stage.setTitle("Angry Birds");
        stage.setFullScreen(true);

        ImageView background = new ImageView(new Image(getClass().getResource("/images/background.jpg").toExternalForm()));

        background.fitWidthProperty().bind(scene.widthProperty());
        background.fitHeightProperty().bind(scene.heightProperty());
        background.setPreserveRatio(false);

        root.getChildren().add(background);
        root.getChildren().add(canvas);
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
                if (currentLevel != null) {
                    update();
                    render();
                }
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

    public void setLevel(Level level) {
        this.currentLevel = level;
        currentLevel.setSlingshot(slingshot);
        currentLevel.initLevel();
        currentBird = currentLevel.nextBird();
        slingshot.setBird(currentBird);

        levelScreen();
    }


    private void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (this.currentLevel != null) {
            currentLevel.drawObject(gc);
        }

    }

    public void exitLevel() {
        currentLevel = null;
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        selectLevelScreen();
    }

    public void update() {
        currentLevel.update(physicsEngine);
        
        if (currentBird != null) {
            if (currentBird.getIsLaunched()) {
                 // Check if the bird has effectively stopped moving
                boolean isStopped = Math.abs(currentBird.getVelocityX()) < 1.0 && Math.abs(currentBird.getVelocityY()) < 1.0;
                if (isStopped) {
                    currentBird = currentLevel.nextBird();
                    slingshot.setBird(currentBird);
                }
            }
        }
    }

    public void onMousePressed(double x, double y) {
        slingshot.onMousePressed(x, y);

    }

    public void onMouseDragged(double x, double y) {
        slingshot.onMouseDragged(x, y);
    }

    public void onMouseReleased(double x, double y) {
        slingshot.onMouseReleased();
    }

    public void onMouseClicked(double x, double y) {
        if(currentBird != null && currentBird.getIsLaunched()){
            currentBird.useAbility();
        }
    }
}
