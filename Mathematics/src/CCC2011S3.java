import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CCC2011S3 {

	public static int[] pow5 = {
		1,
		5,
		25,
		125,
		625,
		3125,
		15625,
		78125,
		390625,
		1953125,
		9765625,
		48828125,
		244140625,
		1220703125,
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int columns = Integer.parseInt(br.readLine());
		int[][] input = new int[columns][3];
		
		for (int i = 0; i < columns; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				input[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for (int i = 0; i < columns; i++) {
			System.out.println(scan(1, input[i][1], input[i][2], input[i][0]));
		}
	}
	
	public static String scan(int mag, int x, int y, int reqmag) {
		int power = pow5[reqmag - mag];
		int newx = x / power;
		int newy = y / power;
		if (((newx == 1) && (newy == 0)) || ((newx == 2) && (newy == 0)) || ((newx == 3) && (newy == 0)) || ((newx == 2) && (newy == 1))) return "crystal";
		else if ((((newx == 1) && (newy == 1)) || ((newx == 2) && (newy == 2)) || ((newx == 3) && (newy == 1))) && !(mag == reqmag)) return scan(mag + 1, x % power, y % power, reqmag);
		else return "empty";
	}

}
