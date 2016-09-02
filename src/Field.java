import java.awt.*;

/**
 * Created by YSK on 2016/9/1.
 */
public class Field{
    private int height;
    private int width;

    public Field(int height, int width){
        this.height = height;
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }
}
