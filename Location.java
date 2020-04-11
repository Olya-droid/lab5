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
    public Double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Location(" +
                "x = " + x +
                ", y = " + y +
                ", name = " + name +
                ')';
    }

}
