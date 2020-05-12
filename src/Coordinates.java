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

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates(" +
                "x = " + x
                +  ", y = " + y
                + ')';
    }
}
