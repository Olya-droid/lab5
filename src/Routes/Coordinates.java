package Routes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coordinates {
    public Coordinates(int x,  float y) {
        this.x = x;
        this.y = y;
    }
    private int x; //Значение поля должно быть больше -836
    private float y; //Максимальное значение поля: 840, Поле не может быть null

    public int getX() {
        return x;
    }
    
    @XmlElement
    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    @XmlElement
    public void setY(float y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "Routes.Coordinates(" +
                "x = " + x
                +  ", y = " + y
                + ')';
    }
}
