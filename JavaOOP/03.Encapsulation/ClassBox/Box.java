package ClassBox;

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
        validationData(length , "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validationData(width , "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validationData(height , "Height");
        this.height = height;
    }

    //calculateSurfaceArea (): double
    //calculateLateralSurfaceArea (): double
    //calculateVolume (): double

    public double calculateSurfaceArea () {
        //2lw + 2lh + 2wh 2 3 4
        // 2 * 2 * 3 + 2 * 2 *
        return (2 * length * width) + calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea () {
        //2lh + 2wh
        return (2 * length * height) + (2 * width * height);
    }

    public double calculateVolume () {
        return this.length * this.width * this.height;
    }

    private double validationData (double side , String parameter){
        if (side <= 0 ){
            throw new IllegalArgumentException(parameter + " cannot be zero or negative.");
        }
        return side;
    }
}
