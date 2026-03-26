import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Obstacle extends GameObject {

    private int health;
    private String type;

    public Obstacle(double x, double y, double width, double height, String type) {
        super(x, y, width, height);

        this.type = type;
        switch (type) {
            case "Glass":
                this.health = 30;
            case "Wood":
                this.health = 65;
            case "Stone":
                this.health = 100;
        }
    }

    /*public String getType() {
        return this.type;
    }*/

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        switch (this.type) {
            case "Glass":
                gc.setFill(Color.BLUE);
            case "Wood":
                gc.setFill(Color.BROWN);
            case "Stone":
                gc.setFill(Color.GREY);
        }
    }

}
