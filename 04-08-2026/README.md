# Programming Exercises - April 8, 2026

## Exercise 1: Factorial Sum

## Question: Write a Java program to print the following pattern : 1! + 2! + 3! + ... + n

### Code

```java
public class FactorialSum {
    public static void main(String args[]) {
        int n = 5;
        int i, fact = 1, sum = 0;

        for (i = 1; i <= n; i++) {
            fact *= i;
            sum += fact;
        }

        System.out.println("The Sum Of Factorials From 1 To " + n + " Is: " + sum);
    }
}
```

### Output

```text
The Sum Of Factorials From 1 To 5 Is: 153
```

## Exercise 2: Hello World

## Question: Write a Java program to print Hello World

### Code

```java
class HelloWorld {
    public static void main(String args[]) {
        System.out.print("Hello World!");
    }
}
```

### Output

```text
Hello World!
```

## Exercise 3: Pattern One

## Question: Write a Java program to print the following pattern

```
* * * *
  * * *
    * *
      *
```

### Code

```java
public class PatternOne {
    public static void main(String args[]) {

        int n = 4;
        int i, j;

        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (j = 0; j < n - i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }
}
```

### Output

```text
* * * * 
  * * * 
    * * 
      *
```

## Exercise 4: Pattern Two

## Question: Write a Java program to print the following pattern

```
1
1 2
1 2 3
1 2 3 4
```

### Code

```java
public class PatternTwo {
    public static void main(String args[]) {
        int n = 4;
        int i, j;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
```

### Output

```text
1 
1 2 
1 2 3 
1 2 3 4
```

## Exercise 5: Prime Number

## Question: Write a Java program to determine whether a number is prime

### Code

```java
public class PrimeNumber {
    public static void main(String args[]) {
        int n = 511111;
        int i, count = 0;

        for (i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                break;
            }
        }

        if (count == 0 && n > 1) {
            System.out.println(n + " Is A Prime Number.");
        } else {
            System.out.println(n + " Is Not A Prime Number.");
        }
    }
}
```

### Output

```text
511111 Is A Prime Number.
```
