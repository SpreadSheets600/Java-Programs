# Programming Exercises - September 8, 2026

## Experiment 1 : Write a Java program to perform arithmetic operations using command-line arguments.

### Code :

```java
class Arithmetic {
    public static void main(String args[]) {

        int x = Integer.parseInt(args[0]);
        char operation = args[1].charAt(0);
        int y = Integer.parseInt(args[2]);

        switch (operation) {
            case '+':
                System.out.println(x + y);
                break;

            case 'm':
                System.out.println(x * y);
                break;

            default:
                System.out.println("INVALID OPERATION!");
                break;
        }
    }
}
```

### Output :

```text
java Arithmetic 10 + 20
30

java Arithmetic 10 m 20
200
```

## Experiment 2 : Write a Java program to compare two strings.

### Code :

```java
class Compare {
    public static void main(String args[]) {

        String first = args[0];
        String second = args[1];

        if (first.equals(second)) {
            System.out.println("Both Are Same");
        } else {
            System.out.println("Both Are Not Same");
        }

        System.out.println(first.compareTo(second));

        if (first.compareTo(second) == 0) {
            System.out.println("Both Are Same");
        } else {
            System.out.println("Both Are Not Same");
        }
    }
}
```

### Output :

```text
java Compare hello hello
Both are same
0
Both are same

java Compare hello world
Both are not same
-15
Both are not same
```

## Experiment 3 : Write a Java program to check whether a given word is a palindrome.

### Code :

```java
class Palindrome {
    public static void main(String args[]) {

        String word = "madam";
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }

        if (word.compareTo(reverse) == 0) {
            System.out.println("The Word Is PALINDROME");
        } else {
            System.out.println("The Word Is NOT PALINDROME");
        }
    }
}
```

### Output :

```text
The word is PALINDROME
```
