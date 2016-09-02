import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by YSK on 2016/9/2.
 */
public class SnakePro {
    private Field field;
    private Snake snake;
    private Food food;
    private View view;

    public SnakePro(int size){
        field = new Field(size, size);
        snake = new Snake(field);
        food = new Food(-1, -1, field);
        view = new View(field, food, snake);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        snake.setDirectionUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.setDirectionDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        snake.setDirectionLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.setDirectionRight();
                        break;
                }
            }
        });
    }

    public void start(){
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!food.isAvailable()){
                food.reFresh(snake);
            }
            try {
                snake.snakeGo(food);
            } catch (DieException e) {
                JOptionPane.showMessageDialog(null, "alert", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            view.repaint();
        }
    }

    public static void main(String[] args) {
        SnakePro test = new SnakePro(80);
        test.start();
    }
}
