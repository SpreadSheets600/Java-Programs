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
