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
