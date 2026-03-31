package gameEngine;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.Canvas;

public class InputHandler {

    private Game game;

    public InputHandler( Canvas canvas, Game game) {
        this.game = game;

        canvas.setOnMousePressed(this::mousePressed);
        canvas.setOnMouseDragged(this::mouseDragged);
        canvas.setOnMouseReleased(this::mouseReleased);
        /*canvas.setOnMousePressed(this::mouseClicked);*/
    }

    private void mousePressed(MouseEvent e) {
        game.onMousePressed(e.getX(), e.getY());
    }
    private void mouseDragged(MouseEvent e){
        game.onMouseDragged(e.getX(), e.getY());
    }
    private void mouseReleased(MouseEvent e) {
        game.onMouseReleased(e.getX(), e.getY());
    }

    private void mouseClicked(MouseEvent e) {
        game.onAbilityClick(e.getX(), e.getY());
    }



}
