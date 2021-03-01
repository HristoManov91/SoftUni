package Exercise_01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        validationParameter(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validationParameter(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validationParameter(height, "Height");
        this.height = height;
    }

    private void validationParameter(double length, String side) {
        if (length <= 0) {
            throw new IllegalArgumentException(side + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea () {
        return (2 * length * width) + calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea () {
        return (2 * length * height) + (2 * width * height);
    }

    public double calculateVolume () {
        return this.length * this.width * this.height;
    }
}
