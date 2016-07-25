import java.util.Scanner;

public class CompSciQ1D091014 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		byte var1 = in.nextByte();
		byte var2 = (byte) (var1/2);
		byte counter = 0;

		if (var1 <= 10) {
			for (; var2 >= 0; var2--) {
				System.out.println((var2) + " " + (var1 - var2));
				if (var1 - var2 < 6)
					counter++;
			}
			System.out.println(counter);
		} else {
			System.out.println("Invalid!");
		}
	}

}
