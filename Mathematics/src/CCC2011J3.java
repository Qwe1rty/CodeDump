import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CCC2011J3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numone = Integer.parseInt(br.readLine());
		int numtwo = Integer.parseInt(br.readLine());
		int seqlength = 2;
		int numthree = 0;
		
		while (true) {
			
			if (numtwo > numone) {
				System.out.println(seqlength);
				Thread.currentThread().interrupt();
				return;
			}

			numthree = numone - numtwo;
			numone = numtwo;
			numtwo = numthree;
			seqlength++;

		}
	}

}
