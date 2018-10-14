/**
 * Created by Wolfgang Mühlbauer on 12.05.2017.
 */
public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color) {
        super(side, side, color);
    }

    public double getSide() {
        return super.width;  // or just return width
    }

    public void setSide(double side) {
        super.width = side;  // or just width = side
        super.length = side; // both
    }


    @Override
    public void setWidth(double side) {
        super.width = side;  // or just width = side
        super.length = side;
    }

    @Override
    public void setLength(double length) {
        super.width = length;  // or just width = side
        super.length = length;
    }

    @Override
    public String toString() {
        return "A Square with side " + width + ", subclass of " + super.toString();
    }
}
