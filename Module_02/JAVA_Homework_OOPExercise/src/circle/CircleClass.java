package circle;

import java.util.Map;

public class CircleClass {
    private double radius = 1.0;

    public CircleClass() {
    }

    public CircleClass(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public double getCircumference() {
        return this.radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Another circle.Circle{" +
                "radius = " + radius +
                " , area = " + getArea() +
                " , circumference = " + getCircumference() +
                '}';
    }
}
