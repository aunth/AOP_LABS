
import java.util.Scanner;

class ex3 {

	public static double calculateCurentElement(int x) {
		if (x % 2 == 0) {
			return x * Math.pow(3, x) / factorial(x);
		} else {
			return (x + 1) / Math.pow(2, x);
		}
	}

	private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

	public static void main(String[] argv) {
		
		Scanner scanner = new Scanner(System.in);

		int n;
		double result = 0;

		while (true) {
			System.out.print("Give me n - number of element which you want to sum: ");

			String s = scanner.nextLine();
			try {
				n = Integer.parseInt(s);
				break;
			} catch (NumberFormatException e) {
				System.out.println("n should be a number");
			}
		}
		for (int i = 1; i <= n; i++) {
			result += calculateCurentElement(i);
		}
		System.out.printf("Sum of the series is %.3f", result);
		
	}
}