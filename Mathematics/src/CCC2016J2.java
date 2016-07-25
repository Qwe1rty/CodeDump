import java.util.Scanner;

/*
 * Caleb Tiger Choi
 * Richmond Hill High School (058100924)
 * Junior Division
 * Question J2
 */

public class CCC2016J2 {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		
		int[][] square = new int[4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) 
				square[i][j] = in.nextInt();
		
		int sum = 0;
		for (int i = 0; i < 4; i++) sum += square[0][i];
		
		for (int i = 0; i < 4; i++)
			if (!(square[0][i] + square[1][i] + square[2][i] + square[3][i] == sum)) {
				System.out.println("not magic");
				System.exit(0);
			} else if (!(square[i][0] + square[i][1] + square[i][2] + square[i][3] == sum)) {
				System.out.println("not magic");
				System.exit(0);
			}
		System.out.println("magic");
		
		in.close();
	}
}
