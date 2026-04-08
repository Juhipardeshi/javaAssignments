// Part 1: Shapes (Constructor + Method Overloading)

class Shapes {

    double area;

    // Constructor Overloading
    Shapes(double radius) {
        area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    Shapes(double length, double breadth) {
        area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    Shapes(int side) {
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    // Method Overloading
    void calculateArea(double radius) {
        System.out.println("Circle Area (method): " + (Math.PI * radius * radius));
    }

    void calculateArea(double length, double breadth) {
        System.out.println("Rectangle Area (method): " + (length * breadth));
    }

    void calculateArea(int side) {
        System.out.println("Square Area (method): " + (side * side));
    }
}


// Part 2: Hillstations (Method Overriding)

class Hillstations {

    void famousfood() {
        System.out.println("General hill station food");
    }

    void famousfor() {
        System.out.println("Known for scenic beauty");
    }
}

// Subclass 1
class Manali extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Manali is famous for Siddu");
    }

    @Override
    void famousfor() {
        System.out.println("Manali is famous for snow mountains");
    }
}

// Subclass 2
class Mahabaleshwar extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Mahabaleshwar is famous for strawberries");
    }

    @Override
    void famousfor() {
        System.out.println("Mahabaleshwar is famous for viewpoints");
    }
}

// Subclass 3
class Ooty extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Ooty is famous for chocolates");
    }

    @Override
    void famousfor() {
        System.out.println("Ooty is famous for tea gardens");
    }
}


// Main Class

public class CombinedDemo {
    public static void main(String[] args) {

        System.out.println("----- SHAPES (OVERLOADING) -----");

        // Constructor Overloading
        Shapes s1 = new Shapes(5.0);
        Shapes s2 = new Shapes(4.0, 6.0);
        Shapes s3 = new Shapes(4);

        System.out.println();

        // Method Overloading
        s1.calculateArea(3.0);
        s1.calculateArea(5.0, 2.0);
        s1.calculateArea(6);

        System.out.println("\n----- HILL STATIONS (OVERRIDING) -----");

        Hillstations h;

        // Runtime Polymorphism
        h = new Manali();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Mahabaleshwar();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Ooty();
        h.famousfood();
        h.famousfor();
    }
}