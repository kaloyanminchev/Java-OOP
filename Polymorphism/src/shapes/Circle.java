package shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        Double perimeter = 2 * Math.PI * radius;
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        Double area = Math.PI * (radius * radius);
        super.setArea(area);
    }
}
