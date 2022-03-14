
public class CircleWithException extends GeometricObject {

    public static void main(String[] args) {
        System.out.println("Circle1 test:");
        CircleWithException circle1 = new CircleWithException(100);
        System.out.println("The radius is " + circle1.getRadius());
        try {
            System.out.println("The area is " + circle1.getArea());
            // } catch (PropertyLimitException e) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Circle1 test:");
        CircleWithException circle2 = new CircleWithException(-11);
        System.out.println("The radius is " + circle2.getRadius());
        try {
            System.out.println("The area is " + circle2.getArea());
            // } catch (PropertyLimitException e) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // #region Constructors

    public CircleWithException() {
        super();
        setRadius(1);
    }

    public CircleWithException(double radius) {
        super();
        setRadius(radius);
    }

    public CircleWithException(double radius, String color, boolean filled) {
        super(color, filled);
        setRadius(radius);
    }

    // #endregion

    // #region Private variables with Getters and Setters

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Given radius must be a positive value!");
        this.radius = radius;
    }

    // #region Constructors

    // #region Public Methods

    public double getArea() throws Exception {
        // public double getArea() throws PropertyLimitException {
        double area = 3.14159265358979323 * this.getRadius() * this.getRadius();
        // if (area > 1000)
        // throw new PropertyLimitException("Area must be less than 1000!");
        if (area > 1000)
            throw new Exception("Area must be less than 1000!");
        return area;
    }

    public double getDiameter() {
        return this.getRadius() * 2;
    }

    public double getPerimeter() {
        return 3.14159265358979323 * this.getDiameter();
    }

    public void printCircle() {
        try {
            System.out.print(
                    super.toString() + "\n"
                            + "Colour: " + this.getColor() + "\n"
                            + "Is this filled: " + this.isFilled() + "\n"

                            + "Radius: " + this.getRadius() + "\n"
                            + "Area: " + this.getArea() + "\n"
                            + "Diameter: " + this.getDiameter() + "\n"

                            + "Perimeter: " + this.getPerimeter() + "\n");
            // } catch (PropertyLimitException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // #endregion

}
