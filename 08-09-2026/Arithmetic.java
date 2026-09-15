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
