public class Shape {

    /**
     * Variablen
     */
    protected String colour = "red";
    protected double lineWidth = Math.random()* 2; //Not 0 + 2 cause x*0 = 0

    /**
     * Functions
     */
    Shape(){}

    Shape(String colour){}

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Shape(colour: " + colour + "line width: " + lineWidth + ")";
    }
}



