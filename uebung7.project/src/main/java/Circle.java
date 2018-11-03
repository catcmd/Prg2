
public class Circle extends Shape {

    /**
     * Variables
     */

     private double radius;

    /**
     * Funktionen
     */

    /**
     * Constructor sets param this.radius to radius
     * @param radius
     */
    public Circle(double radius){
        this.radius = radius;
    }

    /**
     * Constructor is overloaded sets calls up on radius
     * and sets colour in super class to colour
     * @param radius
     * @param colour
     */
    public Circle(double radius, String colour){
        this(radius);
        super.colour = colour;
    }

    /**
     * gets radius from this radius and returns it
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     *Function calculates the Area and returns it
     * @return
     */
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Function calcs Perimeter and returns it
     * @return
     */
    public double getPerimeter() {
        return radius*2;
    }

    /**
     * Gives out the to String with class information
     * @return
     */
    @Override
    public String toString() {
        return "Circle(radius" + radius+ "Area: " + getArea() + ") is a " +  super.toString();
    }
}
