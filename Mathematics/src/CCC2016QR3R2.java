import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CCC2016QR3R2 {

	public static void main(String[] args) throws Exception {
		long ctime = System.currentTimeMillis();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = input.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		ArrayList<Integer[]> redBlocks = new ArrayList<Integer[]>();
		for (int i = 0; i < m; i++) {
			String[] srb = input.readLine().split(" ");
			int[] redBlock = {Integer.parseInt(srb[0]) - 1, Integer.parseInt(srb[1]) - 1};
			checkSize(redBlock, redBlocks);
		}
		System.out.println(countFilled(n, redBlocks)); // answer
	}

	// count filled boxes
	public static long countFilled(int n, ArrayList<Integer[]> redBlocks) {
		long count = 0;
		int currentCol, currentHeight = 0, prevCol = 0, prevHeight = 0;
		while (redBlocks.size() > 0) {
			currentCol = Integer.MAX_VALUE;
			int index = 0;
			for (int i = 0; i < redBlocks.size(); i++)
				if (redBlocks.get(i)[1] < currentCol) {
					currentCol = redBlocks.get(i)[1];
					currentHeight = n - redBlocks.get(i)[0];
					index = i;
				}
			redBlocks.remove(index);			
			if (prevHeight - (currentCol - prevCol) > 0) count += sqd(prevHeight - (currentCol - prevCol), currentHeight);
			else count += sqd(0, currentHeight);
			prevHeight = currentHeight;
			prevCol = currentCol;
		}
		return count;
	}
	
	public static long sqd(long n1, long n2) { // smaller, bigger
		return ((n2 * (n2 + 1)) / 2) - ((n1 * (n1 + 1)) / 2);
	}

	// checks if red block is at the top/needed
	public static void checkSize(int[] redblock, ArrayList<Integer[]> redBlocks) {
		if (redBlocks.size() > 0)
			for (int i = redBlocks.size() - 1; i >= 0; i--)
				if (redblock[0] > redBlocks.get(i)[0] && // below 
						redblock[1] >= redBlocks.get(i)[1] && // leftof
						redblock[1] <= redBlocks.get(i)[1] + (redblock[0] - redBlocks.get(i)[0])) //rightof
					return;
				else if (redblock[0] < redBlocks.get(i)[0] && // above
						redblock[1] <= redBlocks.get(i)[1] && // within left bound
						redblock[1] >= redBlocks.get(i)[1] + (redblock[0] - redBlocks.get(i)[0])) { // within right bound
					redBlocks.remove(i);
				} else if (redblock[0] == redBlocks.get(i)[0] && redblock[1] == redBlocks.get(i)[1]) return;
		redBlocks.add(new Integer[] {redblock[0], redblock[1]});
	}
}
