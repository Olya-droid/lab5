public class Route {
    public static long lastID = 0; // id прошлого элемента, увеличивается при появлении нового элемента
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private Float distance; //Поле может быть null, Значение поля должно быть больше 1

    public Route (String name, Coordinates coordinates, Location from, Location to, Float distance){
        Route.lastID +=1;
        this.id = lastID;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.from = from;
        this.to = to;
        this.distance = distance;

    }
}
