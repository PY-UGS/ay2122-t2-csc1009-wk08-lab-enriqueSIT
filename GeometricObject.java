
public class GeometricObject {

    // #region Constructors

    public GeometricObject() {
        this.setColor("White");
        this.setFilled(false);
        this.dateCreated = new java.util.Date();
    }

    public GeometricObject(String color, boolean filled) {
        this.setColor(color);
        this.setFilled(filled);
        this.dateCreated = new java.util.Date();
    }

    // #endregion

    // #region Private variables with Getters and Setters

    private java.util.Date dateCreated;

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    private boolean filled;

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // #endregion

    // Oh, it only returns the date. lel
    public String toString() {
        return "created on: " + this.getDateCreated().toString();
        // If we have spare spacing to format slightly nicer.
        // return "Created on: " + this.getDateCreated().toString() + "\n" + "Colour: "
        // + this.getColor() + "\n" + "Is this filled: " + this.isFilled() + "\n";
        // If we need a more compact layout
        // return "Created on: " + this.getDateCreated().toString() + ". " + "Colour: "
        // + this.getColor() + ". " + "Is this filled: " + this.isFilled() + "\n";
    }

}
