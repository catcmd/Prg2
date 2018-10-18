/**
 * Created by Wolfgang Mühlbauer on 11.05.2017.
 */
public class Circle extends Shape {

    final private double radius;

    public Circle(double radius) {
        this.radius = radius;          // Here: super not mandatory due to existence of default constructor in super class
    }

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle(radius=" + radius + "), subclass of " + super.toString();
    }
}
