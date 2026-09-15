import java.util.Scanner;

// Interface Shape
interface Shape {
    double PI = 3.14159;

    double calculateArea();
    double calculateVolume();
}

// Sphere class
class Sphere implements Shape {
    double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 4 * PI * radius * radius;
    }

    public double calculateVolume() {
        return (4.0 / 3) * PI * radius * radius * radius;
    }
}

// Cylinder class
class Cylinder implements Shape {
    double radius, height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double calculateArea() {
        return 2 * PI * radius * (radius + height);
    }

    public double calculateVolume() {
        return PI * radius * radius * height;
    }
}

// Cone class
class Cone implements Shape {
    double radius, height;

    Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double calculateArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return PI * radius * (radius + slantHeight);
    }

    public double calculateVolume() {
        return (1.0 / 3) * PI * radius * radius * height;
    }
}

// Main class
public class ShapeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Sphere
        System.out.print("Enter radius of Sphere: ");
        double sphereRadius = sc.nextDouble();
        Shape sphere = new Sphere(sphereRadius);
        System.out.println("\nSphere:");
        System.out.printf("Area: %.2f\n", sphere.calculateArea());
        System.out.printf("Volume: %.2f\n", sphere.calculateVolume());

        // Input for Cylinder
        System.out.print("\nEnter radius of Cylinder: ");
        double cylinderRadius = sc.nextDouble();
        System.out.print("Enter height of Cylinder: ");
        double cylinderHeight = sc.nextDouble();
        Shape cylinder = new Cylinder(cylinderRadius, cylinderHeight);
        System.out.println("\nCylinder:");
        System.out.printf("Area: %.2f\n", cylinder.calculateArea());
        System.out.printf("Volume: %.2f\n", cylinder.calculateVolume());

        // Input for Cone
        System.out.print("\nEnter radius of Cone: ");
        double coneRadius = sc.nextDouble();
        System.out.print("Enter height of Cone: ");
        double coneHeight = sc.nextDouble();
        Shape cone = new Cone(coneRadius, coneHeight);
        System.out.println("\nCone:");
        System.out.printf("Area: %.2f\n", cone.calculateArea());
        System.out.printf("Volume: %.2f\n", cone.calculateVolume());

        sc.close();
    }
}
