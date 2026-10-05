# Programming Exercises - September 29, 2026

## Experiment 1 : Define an interface "Stack" with methods "void push(int item)" and "int pop()". Implement it using two classes, "Class1" for a fixed-size stack and "Class2" for a dynamically growing stack that increases its size when overflow occurs.

### Code :

```java

interface Stack {

    void push(int data);

    int pop();
}

class StaticStack implements Stack {

    int top;
    int size;
    int stack[];

    StaticStack(int size) {
        this.size = size;
        this.top = -1;

        stack = new int[size];
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.print("Stack Overflow");
        } else {
            stack[++top] = data;
            System.out.println(data + " Pushed In Stack");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--];
    }

    void display() {
        int i;

        for (i = top; i >= 0; i--) {
            System.out.print(" " + stack[i]);
        }
    }
}

class DynamicStack implements Stack {

    int top;
    int size;
    int stack[];

    DynamicStack(int size) {
        this.size = size;
        this.top = -1;

        stack = new int[size];
    }

    int data;
    int dstack[];

    public void push(int data) {
        int i;

        if (top == size - 1) {
            System.out.println("Expanding Stack Size");
            dstack = new int[size * 2];

            for (i = 0; i <= top; i++) {
                dstack[i] = stack[i];
            }

            stack = dstack;
        }

        stack[++top] = data;
        System.out.println(data + " Pushed In Stack");
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--];
    }

    void display() {
        int i;

        for (i = top; i >= 0; i--) {
            System.out.print(" " + stack[i]);
        }
    }
}

public class StackUtil {

    public static void main(String[] args) {
        StaticStack S1 = new StaticStack(3);
        DynamicStack S2 = new DynamicStack(3);

        S1.push(10);
        S1.push(20);
        S1.push(30);
        S1.push(40);

        S1.display();
        System.out.println();
        S1.pop();
        S1.display();

        System.out.println();
        S2.push(10);
        S2.push(20);
        S2.push(30);
        S2.push(40);
        S2.display();

        System.out.println();
        S2.pop();
        S2.display();

    }
}
```

### Output :

```text
10 Pushed In Stack
20 Pushed In Stack
30 Pushed In Stack
Stack Overflow
 30 20 10

30 Popped From Stack
 20 10

10 Pushed In Stack
20 Pushed In Stack
30 Pushed In Stack
Expanding Stack Size
40 Pushed In Stack
 40 30 20 10

40 Popped From Stack
 30 20 10
```

## Experiment 2 : Write a Java program to demonstrate multiple inheritance using interfaces.

### Code : 

```java

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
```

### Output :

```text
This Is Show Function
This Is Display Function
2
```