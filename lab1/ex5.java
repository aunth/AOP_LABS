
class ex5 {

	public static double func(int x) {
		return 1 - (Math.pow(x, 2)/2) + (Math.pow(x, 4)/4) - (Math.pow(x, 6)/6);
	}

	public static void main(String[] argv) {

		for (int x = 0; x <= 12; x++) {

			System.out.printf("f(%d) = %.4f%n", x, func(x));
		}
	}

}