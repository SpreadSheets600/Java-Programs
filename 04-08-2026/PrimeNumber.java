public class PrimeNumber {

    public static void main(String[] args) {
        int n = 511111;
        int i,
            count = 0;

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
