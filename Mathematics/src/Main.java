import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	private static int n;
	private static int count;
	private static ArrayList<Integer[]> rbs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		System.out.println("starting checksize");
		rbs = new ArrayList<Integer[]>();
		for (int i = 0; i < m; i++) {
			String[] srb = br.readLine().split(" ");
			int[] rb = {Integer.parseInt(srb[0]) - 1, Integer.parseInt(srb[1]) - 1};

			checkSize(rb);
		}
		System.out.println("ending checksize");
		System.out.println("starting countfill");
//		System.out.println(rbs.size());
//		for (int i = 0; i < rbs.size(); i++)
//			System.out.println(rbs.get(i)[0] + " " + rbs.get(i)[1]);
		System.out.println(countFilled());
		System.out.println("ending countfill");
	}

	// count filled boxes
	public static long countFilled() {
		long count = 0;
		for (int i = 0; i < n; i++) {
			long highnum = 0;
			for (int j = rbs.size() - 1; j >= 0; j--) {
				if (rbs.get(j)[1] <= i) {
					int height = n - rbs.get(j)[0] - i + rbs.get(j)[1];
					if (height < 1) rbs.remove(j);
					else if (height > highnum) highnum = height;
				}
			}
			count += highnum;
//			System.out.println(highnum);
		}
		return count;
	}

	// fills in a column
	public static void checkSize(int[] rb) {
		if (rbs.size() > 0) {
			for (int i = rbs.size() - 1; i >= 0; i--) {
				if (rb[0] > rbs.get(i)[0] && // below 
						rb[1] >= rbs.get(i)[1] && // leftof
						rb[1] <= rbs.get(i)[1] + (rb[0] - rbs.get(i)[0])) //rightof
					return;
				else if (rb[0] < rbs.get(i)[0] && // above
						rb[1] <= rbs.get(i)[1] && // within left bound
						rb[1] >= rbs.get(i)[1] + (rb[0] - rbs.get(i)[0])) { // within right bound
					rbs.remove(i);
				}
			}
		}
		rbs.add(new Integer[] {rb[0], rb[1]});
		//		for (int i = rb[1]; i < n; i++) {
		//			if ((n - i) - (rb[0] - rb[1]) > p[i]) {
		//				p[i] = (n - i) - (rb[0] - rb[1]);
		//			} else return;
		//		}
	}
}
