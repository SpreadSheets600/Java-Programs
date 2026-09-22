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