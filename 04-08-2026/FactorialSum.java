public class FactorialSum {

    public static void main(String[] args) {
        int n = 5;
        int i,
            fact = 1,
            sum = 0;

        for (i = 1; i <= n; i++) {
            fact *= i;
            sum += fact;
        }

        System.out.println(
            "The Sum Of Factorials From 1 To " + n + " Is: " + sum
        );
    }
}
