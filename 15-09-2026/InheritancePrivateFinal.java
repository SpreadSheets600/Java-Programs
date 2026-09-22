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