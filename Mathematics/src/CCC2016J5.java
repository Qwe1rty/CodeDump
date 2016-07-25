import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Caleb Tiger Choi
 * Richmond Hill High School (058100924)
 * Junior Division
 * Question J5
 */

public class CCC2016J5 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int qtype = Integer.parseInt(br.readLine());
		int bikes = Integer.parseInt(br.readLine());
		
		String[] asd = br.readLine().split(" ");
		String[] asdf = br.readLine().split(" ");
		int[] dmoj = new int[bikes];
		int[] peg = new int[bikes];
		for (int i = 0; i < bikes; i++) {
			dmoj[i] = Integer.parseInt(asd[i]);
			peg[i] = Integer.parseInt(asdf[i]);
		}
		
		Arrays.sort(dmoj);
		Arrays.sort(peg);

		int speedsum = 0;
		if (qtype == 1) {
			for (int i = 0; i < bikes; i++) speedsum += max(dmoj[i], peg[i]);
		} else if (qtype == 2) {
			int h1 = bikes - 1, h2 = bikes - 1;
			for (int i = 0; i < bikes; i++) {
				speedsum += max(dmoj[h1], peg[h2]);
				if (max(dmoj[h1], peg[h2]) == dmoj[h1]) h1--;
				else h2--;
			}
		} else System.out.println("wat");
		
		System.out.println(speedsum);
	}
	
	public static int max(int a, int b) {
		if (a > b) return a;
		else return b;
	}

}
