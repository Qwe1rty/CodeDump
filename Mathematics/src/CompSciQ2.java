import java.util.Scanner;

public class CompSciQ2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			byte number = input.nextByte();
			String newLine = System.getProperty("line.separator");
			char[] charArray = {'*', '#', '*', ' ', '#', '#', '*', ' ', '*'};
			for (byte k = 0; k < number; k++) {
				for (byte i = 0; i < 3; i++) {
					for (byte j = 0; j < number; j++) {
						System.out.print(charArray[i]);
					}
				}
				System.out.print(newLine);
			}
			for (byte k = 0; k < number; k++) {
				for (byte i = 3; i < 6; i++) {
					for (byte j = 0; j < number; j++) {
						System.out.print(charArray[i]);
					}
				}
				System.out.print(newLine);
			}
			for (byte k = 0; k < number; k++) {
				for (byte i = 6; i < 9; i++) {
					for (byte j = 0; j < number; j++) {
						System.out.print(charArray[i]);
					}
				}
				System.out.print(newLine);
			}
		} finally {
			input.close();
		}
	}

}
