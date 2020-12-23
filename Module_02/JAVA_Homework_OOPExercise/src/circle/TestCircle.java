package circle;

import circle.Circle;
import circle.CircleClass;

public class TestCircle {
    public static void main(String[] args) {

        // Test Ex 1.1: The circle.Circle Class
        Circle circle1 = new Circle();
        System.out.println("The circle has radius of " + circle1.getRadius() + " and area of " + circle1.getArea());

        Circle circle2 = new Circle(2.0);
        System.out.println("The circle has radius of " + circle2.getRadius() + " and area of " + circle2.getArea());

        Circle circle3 = new Circle(3.0, "blue");
        System.out.println("The circle has radius of " + circle3.getRadius() + " and the color is " + circle3.getColor());

        Circle circle4 = new Circle();
        circle4.setRadius(5.5);
        System.out.println("Radius is: " + circle4.getRadius());
        circle4.setColor("yellow");
        System.out.println("Color is: " + circle4.getColor());

        Circle circle5 = new Circle(8.5);
        System.out.println(circle5.toString());
        System.out.println(circle5);

        // Test Ex 1.2: Another circle.Circle Class
        CircleClass c1 = new CircleClass(5.6);
        System.out.println(c1);
    }
}
