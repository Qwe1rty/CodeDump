import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CCC2016QR3 {

	private static boolean[][] p;
	
	public static void main(String[] args) throws Exception {
		// parse input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int[][] rbs = new int[m][2];
		
		p = new boolean[n][];
		for (int i = 0; i < n; i++)
			p[i] = new boolean[i + 1];
		
		for (int i = 0; i < m; i++) {
			String[] rb = br.readLine().split(" ");
			rbs[i] = new int[] {Integer.parseInt(rb[0]) - 1, Integer.parseInt(rb[1]) - 1};
		}

		// actually solves the problem
		for (int i = 0; i < rbs.length; i++)
			if (!p[rbs[i][0]][rbs[i][1]])
				fillValues(rbs[i][0], rbs[i][1]);
		System.out.println(countFilled());
	}
	
	// count filled boxes
	public static long countFilled() {
		long filled = 0;
		for (int i = 0; i < p.length; i++)
			for (int j = 0; j < p[i].length; j++)
				if (p[i][j]) filled++;
		return filled;
	}
	
	// fill all values below
	public static void fillValues(int r, int c) {
		int cs = c;
		int ce = c;
		for (int i = r; i < p.length; i++) { // row
			if (p[i][cs]) cs++;
			boolean incce = true;
			if (p[i][ce]) incce = false;
			for (int j = cs; j <= ce; j++) // col
				p[i][j] = true;
			if (incce) ce++;
		}
	}
	
}
