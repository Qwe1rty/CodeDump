import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Caleb Tiger Choi
 * Richmond Hill High School (058100924)
 * Junior Division
 * Question J1
 */

public class CCC2016J1 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int wins = 0;
		for (int i = 0; i < 6; i++) if (br.readLine().equals("W")) wins++;

		if (wins > 4) System.out.println(1);
		else if (wins > 2) System.out.println(2);
		else if (wins > 0) System.out.println(3);
		else System.out.println(-1);
		
	}
}
