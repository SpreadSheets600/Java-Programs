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
