/**
 * Created by Wolfgang Mühlbauer on 11.05.2017.
 */
public class Rectangle extends Shape {

    protected double width;
    protected double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color) {
        super(color);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

      public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return (2 * width + 2 * length);
    }

    @Override
    public String toString() {
        return "Rectangle(width=" + width + ", length=" + length + "), subclass of " + super.toString();
    }
}


