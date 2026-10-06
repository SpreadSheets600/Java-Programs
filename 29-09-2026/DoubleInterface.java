
interface A {

    double pi = 3.14;

    void show();
}

interface B {

    void display();

    void show();
}

interface C extends A, B {

    int sum(int a, int b);
}

class ABC implements C {

    public void show() {
        System.out.println("This Is Show Function");
    }

    public void display() {
        System.out.println("This Is Display Function");
    }

    public int sum(int a, int b) {
        return a + b;
    }
}

class DoubleInterface {

    public static void main(String[] args) {
        ABC abc = new ABC();

        abc.show();
        abc.display();

        System.out.println(abc.sum(1, 1));
    }
}
