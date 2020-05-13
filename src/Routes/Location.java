package Routes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
    private Long x; //Поле не может быть null
    private Double y; //Поле не может быть null
    private String name; //Поле не может быть null

    public Location(Long x, Double y,  String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public Long getX() {
        return x;
    }
    
    @XmlElement
    public void setX(Long x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    @XmlElement
    public void setY(Double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Routes.Location(" +
                "x = " + x +
                ", y = " + y +
                ", name = " + name +
                ')';
    }

}
