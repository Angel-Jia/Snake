import javax.swing.*;
import java.awt.*;

/**
 * Created by YSK on 2016/9/1.
 */
public class View extends JPanel {

    private static int GRID_SIZE = 14;
    private Field field;
    private Food food;
    private Snake snake;

    public View(Field field, Food food, Snake snake){
        this.field = field;
        this.food = food;
        this.snake = snake;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int row = 0; row < field.getHeight(); row++) {
            g.drawLine(0, row * GRID_SIZE, field.getWidth() * GRID_SIZE, row * GRID_SIZE);
        }

        for (int col = 0; col < field.getWidth(); col++) {
            g.drawLine(col * GRID_SIZE, 0, col * GRID_SIZE, field.getHeight() * GRID_SIZE);
        }
        food.draw(g, GRID_SIZE);
        snake.draw(g, GRID_SIZE);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(field.getWidth() * GRID_SIZE + 1, field.getHeight() * GRID_SIZE + 1);
    }
}
