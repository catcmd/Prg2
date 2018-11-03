public class Rectangle extends Shape  {

    /**
     * Variablen
     */

    private double length;
    private double width;

    /**
     * Default Constructor Constructor without parameter '()'
     */
    private Rectangle() {}

    /**
     * Rectangle without colour
     */
    public Rectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    /**
     * Rectangle with colour
     */
    public Rectangle(double length, double width, String colour)
    {
        this(length, width);
        super.colour = colour;
    }

    /**
     * Gets Length of Rectangle
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets width of Rectangle
     * @return width
     */
    public double getWidth() {
        return width;
    }


    /**
     * Set Length of Rectangle
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Set Width of Rectangle
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *Get area size of Area
     * @return area
     */
    public double getArea() {
        return length*width;
    }

    /**
     * Gets the permieter of Rectangle
     * @return preimeter
     */
    public double getPerimeter() {
        return (length+width)*2;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Rectangle(width: " + width + "length: " + length + ") is a " + super.toString();
    }
}
