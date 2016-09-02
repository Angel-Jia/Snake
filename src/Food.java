import java.awt.*;

/**
 * Created by YSK on 2016/9/2.
 */
public class Food extends Location implements Cube{
    private Field field;

    public Food(int x, int y, Field field) {
        super(x, y);
        this.field = field;
    }

    public boolean isAvailable(){
        return (getX() != -1 && getY() != -1);
    }

    public void reFresh(Snake snake){
        int x, y;
        do {
            x = (int) (Math.random() * field.getWidth());
            y = (int) (Math.random() * field.getHeight());
        }while (snake.getSnake().contains(new Location(x, y)));
        setXY(x, y);
    }

    @Override
    public void draw(Graphics g, int size) {
        g.setColor(Color.red);
        g.fillRect(getX() * size, getY() * size, size, size);
    }
}
