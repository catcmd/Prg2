public class Square extends Rectangle{

    /**
     * Gets Constructor from Rectangle and renames them as side for width and length
     * @param side
     */
    public Square(double side){
        super(side, side);
    }

    /**
     * Overloads the constructor
     * @param side
     * @param colour
     */
    public Square(double side, String colour) {
        this(side);//same as if Square(side) would stand here
        super.colour = colour;
    }

    /**
     * Returns Length as side
     * @return
     */
    public double getSide() {
        return super.getLength();
    }

    /**
     * Norms Width and Length with width
     * @param width
     */
    @Override
    public void setWidth (double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    /**
     * Norms Length
     * @param length
     */
    @Override
    public void setLength(double length) {
        this.setWidth(length);
    }

    /**
     * Sets side with normed as normed width/length
     * @param side
     */
    public void setSide(double side) {
        this.setWidth(side);
    }

    @Override
    public String toString() {
        return "Square(side: " + getSide() + ") is a " + super.toString();
    }
}
