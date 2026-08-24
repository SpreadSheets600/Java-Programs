# Programming Exercises - August 18, 2026

## Experiment 1 : Write a java program to create a class Shape3D with an attribute shape_type of type String and a method find_volume() to calculate the volume of different 3D shapes. Overload the find_volume() method by passing one, two, or three parameters as required for Cube, Sphere, Cone, Cylinder and Cuboid.

### Code :

```java
class Shape3D {

    String shape_type;

    Shape3D(String shape_type) {
        this.shape_type = shape_type;
    }

    // Cube / Sphere
    void find_volume(double a) {
        if (shape_type.equals("cube")) {
            double volume = a * a * a;
            System.out.println("Volume Of Cube = " + volume);
        } else if (shape_type.equals("sphere")) {
            double volume = (4.0 / 3.0) * Math.PI * a * a * a;
            System.out.println("Volume Of Sphere = " + volume);
        }
    }

    // Cone / Cylinder
    void find_volume(double r, double h) {
        if (shape_type.equals("cone")) {
            double volume = (1.0 / 3.0) * Math.PI * r * r * h;
            System.out.println("Volume Of Cone = " + volume);
        } else if (shape_type.equals("cylinder")) {
            double volume = Math.PI * r * r * h;
            System.out.println("Volume Of Cylinder = " + volume);
        }
    }

    // Cuboid
    void find_volume(double l, double w, double h) {
        if (shape_type.equals("cuboid")) {
            double volume = l * w * h;
            System.out.println("Volume Of Cuboid = " + volume);
        }
    }
}

public class Shape3DConst {

    public static void main(String[] args) {
        Shape3D cube = new Shape3D("cube");
        Shape3D cone = new Shape3D("cone");
        Shape3D sphere = new Shape3D("sphere");
        Shape3D cuboid = new Shape3D("cuboid");
        Shape3D cylinder = new Shape3D("cylinder");

        cube.find_volume(5);
        sphere.find_volume(3);
        cone.find_volume(3, 7);
        cylinder.find_volume(3, 7);
        cuboid.find_volume(4, 5, 6);
    }
}
```

### Output :

```text
Volume Of Cube = 125.0
Volume Of Sphere = 113.09733552923255
Volume Of Cone = 65.97344572538566
Volume Of Cylinder = 197.92033717615698
Volume Of Cuboid = 120.0
```

## Experiment 2 : Write a java program to define a class Pen with the attributes type and ink_color, and another class Person with the attributes name and position. Define a member method writing() inside the Person class which takes an object of the Pen class as a parameter and displays a suitable message.

### Code :

```java
class Pen {

    String type;
    String ink_color;

    Pen(String type, String ink_color) {
        this.type = type;
        this.ink_color = ink_color;
    }
}

class Person {

    String name;
    String position;

    Person(String name, String position) {
        this.name = name;
        this.position = position;
    }

    void writing(Pen pen) {
        System.out.println(
            position +
                " " +
                name +
                " Is Writing With A " +
                pen.ink_color +
                " " +
                pen.type +
                " Pen."
        );
    }
}

public class PenPerson {

    public static void main(String[] args) {
        Person p1 = new Person("BM", "Teacher");
        Person p2 = new Person("ABC", "Student");

        Pen pt1 = new Pen("Marker", "Black");
        Pen pt2 = new Pen("Ball", "Blue");

        p1.writing(pt1);
        p2.writing(pt2);
    }
}
```

### Output :

```text
Teacher BM Is Writing With A Black Marker Pen.
Student ABC Is Writing With A Blue Ball Pen.
```
