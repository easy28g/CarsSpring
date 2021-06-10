package kg.megacom.Cars.models;

public class Car {

    private Integer id;
    private String mark;
    private String color;
    private Integer year;

    public Car() {
    }

    public Car(Integer id, String mark, String color, Integer year) {
        this.id = id;
        this.mark = mark;
        this.color = color;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
