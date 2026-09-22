# Programming Exercises - September 15, 2026

## Experiment 1 : Write a Java program to demonstrate abstract class and abstract method by finding volume of Sphere, Cube, Cylinder and Cone.

### Code :

```java
abstract class Shape3D {
    double dim1, dim2;

    Shape3D(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    void display() {
        System.out.println("Dimension 1 : " + dim1);
        System.out.println("Dimension 2 : " + dim2);
    }

    abstract void findVol();
}

class Sphere extends Shape3D {

    Sphere(double radius) {
        super(radius, 0);
    }

    void findVol() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(dim1, 3);
        System.out.println("Volume Of Sphere: " + volume);
    }
}

class Cube extends Shape3D {

    Cube(double side) {
        super(side, 0);
    }

    void findVol() {
        double volume = Math.pow(dim1, 3);
        System.out.println("Volume Of Cube: " + volume);
    }
}

class Cylinder extends Shape3D {

    Cylinder(double radius, double height) {
        super(radius, height);
    }

    void findVol() {
        double volume = Math.PI * Math.pow(dim1, 2) * dim2;
        System.out.println("Volume Of Cylinder : " + volume);
    }
}

class Cone extends Shape3D {

    Cone(double radius, double height) {
        super(radius, height);
    }

    void findVol() {
        double volume = (1.0 / 3.0) * Math.PI * Math.pow(dim1, 2) * dim2;
        System.out.println("Volume Of Cone : " + volume);
    }
}

public class AbstractionMethod {
    public static void main(String[] args) {

        Sphere sphere = new Sphere(5);
        sphere.display();
        sphere.findVol();

        System.out.println();

        Cube cube = new Cube(4);
        cube.display();
        cube.findVol();

        System.out.println();

        Cylinder cylinder = new Cylinder(3, 7);
        cylinder.display();
        cylinder.findVol();

        System.out.println();

        Cone cone = new Cone(3, 7);
        cone.display();
        cone.findVol();
    }
}
```

### Output :

```text
Dimension 1 : 5.0
Dimension 2 : 0.0
Volume Of Sphere: 523.5987755982989

Dimension 1 : 4.0
Dimension 2 : 0.0
Volume Of Cube: 64.0

Dimension 1 : 3.0
Dimension 2 : 7.0
Volume Of Cylinder : 197.92033717615698

Dimension 1 : 3.0
Dimension 2 : 7.0
Volume Of Cone : 65.97344572538566
```

## Experiment 2 : Write a Java program to demonstrate multilevel inheritance using final method.

### Code :

```java
class First {
    // Final method cannot be overridden
    final void display() {
        System.out.println("This is a final method of First class.");
    }
}

class Second extends First {
    void showSecond() {
        System.out.println("This is the Second class.");
    }
}

class Third extends Second {
    void showThird() {
        System.out.println("This Is The Third Class.");
    }
}

public class InheritanceMethod {
    public static void main(String[] args) {
        Third obj = new Third();

        // Method Inherited From First Class
        obj.display();

        // Method Of Second Class
        obj.showSecond();

        // Method Of Third Class
        obj.showThird();
    }
}
```

### Output :

```text
This is a final method of First class.
This is the Second class.
This Is The Third Class.
```

## Experiment 3 : Write a Java program to demonstrate the use of private and final variables in inheritance.

### Code :

```java
class A {
    int x = 10;
    private int y = 20;
    final int z = 30;

    int getValue() {
        return y;
    }

    void display() {
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
        System.out.println("Z = " + z);
    }
}

class B extends A {

    void show() {
        x = x + 5;

        int y = getValue() + 5;

        System.out.println("Modified values:");
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
        System.out.println("Z = " + z);
    }
}

public class InheritancePrivateFinal {
    public static void main(String[] args) {
        B obj = new B();

        System.out.println("Original Values :");
        obj.display();

        System.out.println();

        obj.show();
    }
}
```

### Output :

```text
Original Values :
X = 10
Y = 20
Z = 30

Modified values:
X = 15
Y = 25
Z = 30
```
