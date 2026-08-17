class Shape2D {

    double dim1;
    double dim2;
    double Area;

    Shape2D() {
        System.out.println("Constructor Created Successfully \n");
    }

    Shape2D(double x, double y) {
        this.dim1 = x;
        this.dim2 = y;
    }

    Shape2D(double x) {
        this.dim1 = this.dim2 = x;
    }

    Shape2D(Shape2D obj) {
        this.dim1 = obj.dim1;
        this.dim2 = obj.dim2;
    }

    void GetArea() {
        this.Area = this.dim1 * this.dim2;
    }

    void Display() {
        System.out.println("Dimension 1 : " + dim1);
        System.out.println("Dimension 2 : " + dim2);

        GetArea();

        System.out.println("The Area Of The Shape Is : " + this.Area + "\n");
    }
}

class Shape2DConst {

    public static void main(String[] args) {
        Shape2D box1 = new Shape2D();
        Shape2D box2 = new Shape2D(5.5);
        Shape2D box3 = new Shape2D(7.5, 9.5);

        Shape2D box4 = new Shape2D(box3);

        box1.Display();
        box2.Display();
        box3.Display();
        box4.Display();
    }
}
