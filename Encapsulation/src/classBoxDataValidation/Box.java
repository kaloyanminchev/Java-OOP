package classBoxDataValidation;

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
        Validator.validateSide(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        Validator.validateSide(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        Validator.validateSide(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width
                + calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height
                + 2 * this.width * this.height;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
