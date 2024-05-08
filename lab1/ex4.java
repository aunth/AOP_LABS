

class ex4 {

	public static boolean isSimple(int a) {
		if (a < 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] argv) {

		for (int i = 25; i <= 130; i++) {
			if (isSimple(i)) {
				System.out.println(i);
			}
		}
	}
}