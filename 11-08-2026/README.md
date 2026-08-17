# Programming Exercises - August 11, 2026

## Experiment 1 : Write a java program to create a class with default construction imeplementaion and overloaded parameterized constructors.

### Code :

```java
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
```

### Output :

```text
Constructor Created Successfully

Dimension 1 : 0.0
Dimension 2 : 0.0
The Area Of The Shape Is : 0.0

Dimension 1 : 5.5
Dimension 2 : 5.5
The Area Of The Shape Is : 30.25

Dimension 1 : 7.5
Dimension 2 : 9.5
The Area Of The Shape Is : 71.25

Dimension 1 : 7.5
Dimension 2 : 9.5
The Area Of The Shape Is : 71.25
```

## Experiment 2 : Write a java program to create a calculator using a switch case. Implement methods for addition, subtraction, multiplication and division.

### Code :

```java
import java.util.Scanner;

class Solve {

    int a, b, sol;
    float d;

    Solve(int x, int y) {
        a = x;
        b = y;
    }

    void add() {
        sol = a + b;
        System.out.println("Sum Of " + a + " And " + b + " Is : " + sol);
    }

    void subtract() {
        sol = a - b;
        System.out.println("Difference Of " + a + " And " + b + " Is : " + sol);
    }

    void multiply() {
        sol = a * b;
        System.out.println("Product Of " + a + " And " + b + " Is : " + sol);
    }

    void division() {
        if (b != 0) {
            d = (float) a / (float) b;
            System.out.println("Division Of " + a + " And " + b + " Is : " + d);
        } else {
            System.out.println("Zero Division Not Possible");
        }
    }
}

class Calculator {

    public static void main(String[] args) {
        System.out.println("Please Select The Calculator Operations ~ \n");

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit \n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Choice : ");
        int ch = sc.nextInt();

        System.out.print("Enter Number 1 : ");
        int num1 = sc.nextInt();

        System.out.print("Enter Number 2 : ");
        int num2 = sc.nextInt();

        sc.close();

        Solve getSol = new Solve(num1, num2);

        switch (ch) {
            case 1:
                getSol.add();
                break;
            case 2:
                getSol.subtract();
                break;
            case 3:
                getSol.multiply();
                break;
            case 4:
                getSol.division();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Please Enter A Valid Choice");
                break;
        }
    }
}
```

### Output :

```text
Please Select The Calculator Operations ~

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit

Enter Your Choice : 2
Enter Number 1 : 6
Enter Number 2 : 7
Difference Of 6 And 7 Is : -1


Please Select The Calculator Operations ~

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit

Enter Your Choice : 1
Enter Number 1 : 6
Enter Number 2 : 7
Sum Of 6 And 7 Is : 13
```
