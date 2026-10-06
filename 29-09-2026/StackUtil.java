
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
            System.out.print("Stack Overflow\n");
        } else {
            stack[++top] = data;
            System.out.println(data + " Pushed In Stack");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow\n");
            return -1;
        }

        System.out.println(stack[top] + " Popped From Stack");

        return stack[top--];
    }

    void display() {
        int i;

        for (i = top; i >= 0; i--) {
            System.out.print(" " + stack[i]);
        }

        System.out.println();
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

        System.out.println(stack[top] + " Popped From Stack");

        return stack[top--];
    }

    void display() {
        int i;

        for (i = top; i >= 0; i--) {
            System.out.print(" " + stack[i]);
        }

        System.out.println();
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
