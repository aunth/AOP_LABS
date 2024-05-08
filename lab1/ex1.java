import java.util.Scanner;


public class ex1 {

	public static void error_message() {
		System.out.println("You typed incorrect cordinate of the point. Should be like 2 2");
	}
	public static void main(String[] argv) {

		float x1,y1,x2,y2;
		
		Scanner scaner = new Scanner(System.in);
		String[] p1;
		String[] p2;
		
		while (true) {
			System.out.print("Enter cordinate of point A (ex: 1 1) ");
			p1 = (scaner.nextLine()).split(" ");
	
			System.out.print("Enter cordinate of point B (ex: 5 1): ");
			p2 = (scaner.nextLine()).split(" ");
	
			try {
				x1 = Float.parseFloat(p1[0]);
				y1 = Float.parseFloat(p1[1]);
				x2 = Float.parseFloat(p2[0]);
				y2 = Float.parseFloat(p2[1]);
				break;
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				error_message();
			}
		}

		float[] vector = {x2 - x1, y2 - y1};
		System.out.printf("Cordinate of AB vecrot is (%f, %f)%n", vector[0], vector[1]);
		
		double distance = Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);

		System.out.printf("Length of AB vector is %f%n", distance);
	}
}
