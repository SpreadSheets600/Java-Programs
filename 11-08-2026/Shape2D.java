class Shape2D {

    double dim1;
    double dim2;
    double Area;

    Shape2D() {
        System.out.println("Constructor Created Successfully");
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
        System.out.println("Dimention 1 : " + dim1);
        System.out.println("Dimention 2 : " + dim2);

        GetArea();

        System.out.println("The Area Of The Shape Is : " + this.Area);
    }
}
