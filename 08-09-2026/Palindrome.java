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
