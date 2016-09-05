import com.sun.org.apache.bcel.internal.generic.DREM;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by YSK on 2016/9/1.
 */
public class Snake implements Cube{
    private List<Location> snake = new LinkedList<Location>();
    private enum Direction {up, down, right, left}
    private Direction dir;
    private Field field;

    public Snake(Field filed){
        this.field = filed;
        int snakeHeadX = filed.getHeight() / 2;
        int snakeHeadY = filed.getWidth() / 2;
        snake.add(new Location(snakeHeadX, snakeHeadY));
        snake.add(new Location(snakeHeadX, snakeHeadY + 1));
        snake.add(new Location(snakeHeadX, snakeHeadY + 2));
        dir = Direction.up;
    }

    public void snakeGo(Food food) throws DieException{
        Location head = snake.get(0);
        switch (dir){
            case up:
                if(head.getY() == 0 || snake.contains(new Location(head.getX(), head.getY() - 1))){
                    throw new DieException("你输了，游戏结束");
                }
                snake.add(0, new Location(head.getX(), head.getY() - 1));
                break;
            case down:
                if(head.getY() == field.getHeight() || snake.contains(new Location(head.getX(), head.getY() + 1))){
                    throw new DieException("你输了，游戏结束");
                }
                snake.add(0, new Location(head.getX(), head.getY() + 1));
                break;
            case left:
                if(head.getX() == 0 || snake.contains(new Location(head.getX() - 1, head.getY()))){
                    throw new DieException("你输了，游戏结束");
                }
                snake.add(0, new Location(head.getX() - 1, head.getY()));
                break;
            case right:
                if(head.getX() == field.getWidth() || snake.contains(new Location(head.getX() + 1, head.getY()))){
                    throw new DieException("你输了，游戏结束");
                }
                snake.add(0, new Location(head.getX() + 1, head.getY()));
                break;
        }
        if(!food.equals(snake.get(0))){
            snake.remove(snake.size() - 1);
        }else {
            food.setXY(-1, -1);
        }
    }


    public List<Location> getSnake(){
        return snake;
    }

    public void setDirectionUp(){
        System.out.println("up");
        if(dir != Direction.down)
        dir = Direction.up;
    }

    public void setDirectionDown(){
        System.out.println("down");
        if(dir != Direction.up)
        dir = Direction.down;
    }

    public void setDirectionLeft(){
        System.out.println("left");
        if(dir != Direction.right)
        dir = Direction.left;
    }

    public void setDirectionRight(){
        System.out.println("right");
        if(dir != Direction.left)
        dir = Direction.right;
    }

    @Override
    public void draw(Graphics g, int size) {
        g.setColor(Color.green);
        for (Location loc: snake) {
            g.fillRect(loc.getX() * size, loc.getY() * size, size, size);
        }
        g.setColor(Color.blue);
        g.fillRect(snake.get(0).getX() * size, snake.get(0).getY() * size, size, size);
    }
}
