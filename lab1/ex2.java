import java.util.Scanner;

class ex2 {

	public static float get_value() {

		while (true) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Give me value of side of triangle: ");

			try {
				float a = Float.parseFloat(scanner.nextLine());
				return a;
			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid float input. Please enter a valid float.");
			}
		}
	}
	public static void main(String[] argv) {

		float a = get_value();
		float b = get_value();
		float c = get_value();

		if (a >= (b + c) || b >= (c + a) || c >= (a + b)) {
			System.out.printf("This values %.2f %.2f %.2f cannot be sides of triangle", a, b, c);
		} else {
			System.out.printf("This values %.2f %.2f %.2f can be sides of triangle", a, b, c);
		}
	}
}