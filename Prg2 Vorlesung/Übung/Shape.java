/**
 * Created by Wolfgang Mühlbauer on 11.05.2017.
 */
public class Shape {

    private String color;
    final private double lineWidth;    // dt. "Linienstärke"

    public Shape() {
        lineWidth = Math.random() * 2;
        color = "red";
    }

    public Shape(String color) {
        this();                  // call default constructor
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // siehe Angabe
    public String toString() {
        String temp = "Shape(color=" + color +", line_width=" + lineWidth + ")";
        return temp;
    }

}
