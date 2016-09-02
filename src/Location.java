/**
 * Created by YSK on 2016/9/1.
 */
public class Location {
    private int x;
    private int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Location tmp = (Location) obj;
        return x == tmp.x && y == tmp.y;
    }
}
