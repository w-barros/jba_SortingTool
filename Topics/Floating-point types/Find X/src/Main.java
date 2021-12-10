import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double x = 0.0;

        while ((a*(x+b)) != c) {
            x = x - 0.1;
        }
        if ((a*(x+b)) == c ) {
            System.out.println(x);
        }
        // put your code here
    }
}
