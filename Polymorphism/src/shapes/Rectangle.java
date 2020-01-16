package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        Double perimeter = 2 * (this.height + this.width);
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        Double area = this.height * this.width;
        super.setArea(area);
    }
}
