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
